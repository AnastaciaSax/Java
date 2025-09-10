/*
Простое число – натуральное (целое положительное) число, имеющее ровно два различных натуральных делителя –
 единицу и самого себя. Другими словами, число N является простым, если оно больше 1 и при этом делится
 без остатка только на 1 и на N (на самого себя).
 Написать программу, которая выводит на экран все простые числа в диапазоне от 2 до 1 000 000

 */
public class Task02 {
    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0 || n < 2) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Prime nums 2 < 1.000.000:");

        for (int number = 2; number <= 1000000; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
