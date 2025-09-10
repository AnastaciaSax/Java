import java.io.*; // in- output
import java.util.*;

interface Operation {
    double execute(double a, double b);
    String getName();
}

class Addition implements Operation {
    public double execute(double a, double b) { return a + b; }
    public String getName() { return "Addition"; }
}

class Subtraction implements Operation {
    public double execute(double a, double b) { return a - b; }
    public String getName() { return "Subtraction"; }
}

class Multiplication implements Operation {
    public double execute(double a, double b) { return a * b; }
    public String getName() { return "Multiplication"; }
}

class Division implements Operation {
    public double execute(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }
    public String getName() { return "Division"; }
}

class Calculator {
    private final String historyFile = "mathLog.txt";

    public double calculate(Operation op, double a, double b) {
        double result = op.execute(a, b);
        saveHistory(op.getName(), a, b, result);
        return result;
    }

    private void saveHistory(String operation, double a, double b, double result) {
        try (FileWriter fw = new FileWriter(historyFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf("%s: %.2f and %.2f = %.2f%n", operation, a, b, result);
        } catch (IOException e) {
            System.out.println("Error writing into file: " + e.getMessage());
        }
    }

    public void showHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader(historyFile))) {
            String line;
            System.out.println("=== Log ===");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("===============");
        } catch (IOException e) {
            System.out.println("No log found");
        }
    }
}

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Show history");
            System.out.println("0. Exit");
            System.out.print("Pick option - ");

            int choice = scanner.nextInt();

            if (choice == 0) break;

            if (choice == 5) {
                calc.showHistory();
                continue;
            }

            System.out.print("Enter 1st num - ");
            double a = scanner.nextDouble();
            System.out.print("Enter 2d num - ");
            double b = scanner.nextDouble();

            Operation op;
            switch (choice) {
                case 1 -> op = new Addition();
                case 2 -> op = new Subtraction();
                case 3 -> op = new Multiplication();
                case 4 -> op = new Division();
                default -> {
                    System.out.println("ERROR! Pick from the list!!!");
                    continue;
                }
            }

            try {
                double result = calc.calculate(op, a, b);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}