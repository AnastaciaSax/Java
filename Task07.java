/*
Даны два числа x и y. Программа должна вывести в консоль YES, –
 если оба числа четные, либо оба числа нечетные; иначе программа ничего не выводит.
 */

import java.util.Scanner;
public class Task07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x = ");
        int x = sc.nextInt();
        System.out.print("y = ");
        int y = sc.nextInt();

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            System.out.println("YES!");
        }
    }
}
