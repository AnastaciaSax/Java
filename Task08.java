/*
С клавиатуры вводится целое число любой разрядности. Программа должна определить и вывести на консоль
количество цифр в этом числе, а так же сумму этих чисел.
 */

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer - ");
        long number = scanner.nextLong();
        long n = Math.abs(number); // if -

        int digitCount = 0;
        long digitSum = 0;

        if (n == 0) {
            digitCount = 1;
            digitSum = 0;
        } else {
            while (n > 0) {
                long digit = n % 10;
                digitSum += digit;
                digitCount++;
                n /= 10;
            }
        }

        System.out.println("Digit number is " + digitCount);
        System.out.println("Digit sum is " + digitSum);

        scanner.close();
    }
}
