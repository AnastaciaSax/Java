import java.util.Scanner;
public class Task04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x = ");
        int x = sc.nextInt();
        System.out.print("y = ");
        int y = sc.nextInt();

        if (x > 0 && y > 0) {
            System.out.println("The point is in 1st quarter");
        } else if (x < 0 && y > 0) {
            System.out.println("The point is in 2d quarter");
        } else if (x < 0 && y < 0) {
            System.out.println("The point is in 3d quarter");
        } else if (x > 0 && y < 0) {
            System.out.println("The point is in 4th quarter");
        } else if (x == 0 && y == 0) {
            System.out.println("The point is at the origin");
        } else if (x == 0) {
            System.out.println("The point is on the y axis");
        } else if (y == 0) {
            System.out.println("The point is on the x axis");
        }
    }
}
