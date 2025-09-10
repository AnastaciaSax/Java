import java.util.Scanner;
public class Task08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x1 = ");
        int x1 = sc.nextInt();
        System.out.print("y1 = ");
        int y1 = sc.nextInt();
        System.out.print("x2 = ");
        int x2 = sc.nextInt();
        System.out.print("y2 =0 ");
        int y2 = sc.nextInt();

        if (x1 == x2) {
            System.out.println("Vertical line");
        } else if (y1 == y2) {
            System.out.println("Flat road");
        } else if (y2 > y1) {
            System.out.println("Uphill");
        } else {
            System.out.println("Downhill");
        }
    }
}
