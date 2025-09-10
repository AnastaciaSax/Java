import java.util.Scanner;
public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hour - ");
        int hour = sc.nextInt();

        if (hour < 0 || hour > 24) {
            System.out.println("ERROR! 0 < 24");
        } else if (hour >= 5 && hour < 12) {
            System.out.println("Rise & shine!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Good afternoon!");
        } else if (hour >= 18 && hour < 23) {
            System.out.println("Evening! How's your day?");
        } else {
            System.out.println("Hey, owl! Let's call it a night");
        }
    }
}
