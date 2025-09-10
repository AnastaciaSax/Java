import java.util.Scanner;
public class Task09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("coefficient a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        System.out.print("c = ");
        double c = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("No solution");
            } else {
                double x = -c / b;
                System.out.println("Linear equation, solution: x = " + x);
            }
        } else {
            double d = b * b - 4 * a * c; // discriminant
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("Two roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (d == 0) {
                double x = -b / (2 * a);
                System.out.println("One root: x = " + x);
            } else {
                System.out.println("No real roots");
            }
        }
    }
}
