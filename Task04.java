/*
Напишите программу, которая будет проверять, является ли число, введенное с клавиатуры палиндромом
(одинаково читающееся в обоих направлениях). Например, 123454321 или 221122 – палиндром.
 Программа должна вывести YES, если число является палиндромом, и NO – в противоположном случае.
 */

import java.util.Scanner;

public class Task04 {
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number - ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("YES +");
        } else {
            System.out.println("NO -");
        }

        scanner.close();
    }
}
