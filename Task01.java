/*
Имеется банк с кассирами, клиентами и их счетами. Клиент может снимать/пополнять/переводить/оплачивать/
обменивать денежные средства. Кассир последовательно обслуживает клиентов. Поток-наблюдатель следит,
чтобы в кассах всегда были наличные, при скоплении денег более определенной суммы, часть их переводится
в хранилище, при истощении запасов наличных происходит пополнение из хранилища.
 */
import java.util.*;
import java.util.concurrent.*; // multithreading
import java.util.concurrent.locks.ReentrantLock; // stop counter

public class Task01 {
    public static void main(String[] args) throws InterruptedException {
        int accountCount = 10;
        int initialBalance = 1000;
        int clientThreads = 9;
        int operationsPerClient = 500;

        Bank bank = new Bank();
        for (int i = 1; i <= accountCount; i++) {
            bank.createAccount(i, initialBalance);
        }

        System.out.printf("Initial total balance: %d%n", bank.totalBalance());

        ExecutorService exec = Executors.newFixedThreadPool(clientThreads);
        List<Future<?>> futures = new ArrayList<>();

        // Launch many clients doing operations
        for (int i = 0; i < clientThreads; i++) {
            ClientTask task = new ClientTask(bank, accountCount, operationsPerClient);
            futures.add(exec.submit(task));
        }

        // Wait for clients to finish
        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        exec.shutdown();
        exec.awaitTermination(5, TimeUnit.SECONDS);

        System.out.printf("Final total balance:   %d%n", bank.totalBalance());
        bank.printAccounts();
    }

    //  Bank and Account class

    public static class Bank {
        private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

        public void createAccount(int id, int initialBalance) {
            accounts.put(id, new Account(id, initialBalance));
        }

        public Account getAccount(int id) {
            return accounts.get(id);
        }

        // Deposit with single-account locking
        public boolean deposit(int accountId, int amount) {
            Account acc = getAccount(accountId);
            if (acc == null) return false;
            acc.lock();
            try {
                acc.deposit(amount);
                return true;
            } finally {
                acc.unlock();
            }
        }

        // Withdraw with single-account locking
        public boolean withdraw(int accountId, int amount) {
            Account acc = getAccount(accountId);
            if (acc == null) return false;
            acc.lock();
            try {
                return acc.withdraw(amount);
            } finally {
                acc.unlock();
            }
        }

        /**
         * Transfer money
         * To avoid deadlock we lock the account with smaller id first.
         */
        public boolean transfer(int fromId, int toId, int amount) {
            if (fromId == toId) return false;
            Account a = getAccount(fromId);
            Account b = getAccount(toId);
            if (a == null || b == null) return false;

            Account first = a.id < b.id ? a : b;
            Account second = a.id < b.id ? b : a;

            // lock in consistent order
            first.lock();
            second.lock();
            try {
                // if from account doesn't have enough money, fail
                if (a.getBalance() < amount) return false;
                a.withdraw(amount);
                b.deposit(amount);
                return true;
            } finally {
                second.unlock();
                first.unlock();
            }
        }

        public int totalBalance() {
            // sum balances under each account lock to get consistent snapshot
            List<Account> snapshot = new ArrayList<>(accounts.values());
            // to avoid locking order issues just lock each account individually and sum
            int sum = 0;
            for (Account acc : snapshot) { //: - foreach snapshot
                acc.lock();
            }
            try {
                for (Account acc : snapshot) sum += acc.getBalance();
            } finally {
                for (Account acc : snapshot) acc.unlock();
            }
            return sum;
        }

        public void printAccounts() {
            List<Account> list = new ArrayList<>(accounts.values());
            list.sort(Comparator.comparingInt(a -> a.id));
            System.out.println("Accounts:");
            for (Account a : list) {
                System.out.printf("  id=%d balance=%d%n", a.id, a.getBalance());
            }
        }
    }

    public static class Account {
        private final ReentrantLock lock = new ReentrantLock();
        final int id; // const
        private int balance;

        public Account(int id, int initialBalance) {
            this.id = id;
            this.balance = initialBalance;
        }

        public void lock() {
            lock.lock();
        }

        public void unlock() {
            lock.unlock();
        }

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            if (amount < 0) throw new IllegalArgumentException("amount must be >= 0");
            balance += amount;
        }

        public boolean withdraw(int amount) {
            if (amount < 0) throw new IllegalArgumentException("amount must be >= 0");
            if (balance < amount) return false;
            balance -= amount;
            return true;
        }
    }

    //  ClientTask simulating operations

    public static class ClientTask implements Runnable {
        private final Bank bank;
        private final int accountCount;
        private final int operations;
        private final Random rnd = ThreadLocalRandom.current();

        public ClientTask(Bank bank, int accountCount, int operations) {
            this.bank = bank;
            this.accountCount = accountCount;
            this.operations = operations;
        }

        @Override
        public void run() {
            for (int i = 0; i < operations; i++) {
                int op = rnd.nextInt(100);
                if (op < 40) {
                    // transfer
                    int from = rndAccount();
                    int to = rndDifferentAccount(from);
                    int amount = rndAmount();
                    bank.transfer(from, to, amount);
                } else if (op < 70) {
                    // deposit
                    int acc = rndAccount();
                    int amount = rndAmount();
                    bank.deposit(acc, amount);
                } else {
                    // withdraw
                    int acc = rndAccount();
                    int amount = rndAmount();
                    bank.withdraw(acc, amount);
                }

                // Optionally yield
                if (i % 100 == 0) Thread.yield();
            }
        }

        private int rndAccount() {
            return rnd.nextInt(accountCount) + 1; // ids are 1..accountCount
        }

        private int rndDifferentAccount(int id) {
            int r;
            do {
                r = rndAccount();
            } while (r == id && accountCount > 1);
            return r;
        }

        private int rndAmount() {
            return rnd.nextInt(200) + 1; // 1..200
        }
    }
}