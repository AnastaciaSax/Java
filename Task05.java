/*
Вывести на консоль все восьмизначные числа, цифры в которых не повторяются.
Эти числа должны делиться на 12345, без остатка. Показать общее количество найденных чисел.
 */

public class Task05 {
    private static boolean doesHaveUniqueDigits(int n) {
        boolean[] digits = new boolean[10]; // digits 0-9

        while (n > 0) {
            int digit = n % 10;
            if (digits[digit]) {
                return false; // digit repeated
            }
            digits[digit] = true;
            n /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("8 digit nums with unique digits that can be divided by 12345:");

        int count = 0;

        for (int number = 10000000; number <= 99999999; number++) {
            if (number % 12345 == 0 && doesHaveUniqueDigits(number)) {
                System.out.println(number);
                count++;
            }
        }

        System.out.println("Total: " + count);
    }
}
