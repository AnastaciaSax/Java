import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // string of sequential integers til 1000
        StringBuilder numbers = new StringBuilder();
        int i = 1;
        while (numbers.length() < 1000) {
            numbers.append(i);
            i++;
        }

        System.out.print("Enter n to find digit - ");
        int n = scanner.nextInt();

        if (n < 1 || n > numbers.length()) {
            System.out.println("Outside of bounds! Enter a number 1 < " + numbers.length());
        } else {
            char digit = numbers.charAt(n - 1); // positions are 1-based
            System.out.println("The digit at position " + n + " is " + digit);
        }

        scanner.close();
    }
}
