public class Task02 {
    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0 || n < 2) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Prime nums 2 < 1.000.000:");

        for (int number = 2; number <= 1000000; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
