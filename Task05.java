/*
Написать программу, проверяющую является ли одна строка анаграммой для другой строки
(строка может состоять из нескольких слов и символов пунктуации). Пробелы и пунктуация должны
игнорироваться при анализе. Разница в больших и маленьких буквах должна игнорироваться.
Обе строки должны вводиться с клавиатуры. Программа должна выводить Yes, если строки являются анаграммой,
 и No – иначе.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two strings
        System.out.print("Enter 1sr string - ");
        String str1 = scanner.nextLine();

        System.out.print("Enter 2d string - ");
        String str2 = scanner.nextLine();

        // remove non-letter characters and convert to lower case
        String cleanStr1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Convert to char arrays and sort
        char[] arr1 = cleanStr1.toCharArray();
        char[] arr2 = cleanStr2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}
