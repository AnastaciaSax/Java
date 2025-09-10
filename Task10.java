import java.util.Scanner;
public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 6 digit number - ");
        String number = sc.nextLine();

        if (number.length() != 6 || !number.matches("\\d{6}")) {
            System.out.println("ERROR! Please enter 6 digits");
            return;
        }

        int sum1 = (number.charAt(0) - '0') + (number.charAt(1) - '0') + (number.charAt(2) - '0');
        int sum2 = (number.charAt(3) - '0') + (number.charAt(4) - '0') + (number.charAt(5) - '0');

        if (sum1 == sum2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
