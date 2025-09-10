/*
Пользователь вводит с клавиатуры букву. Программа должна определить,
в какой раскладке введена буква – в латинской или кириллице.
Вывести в консоль: «латиница», если буква введена латиницей или «кириллице», если буква относится к
кириллическом алфавиту. Если введена цифра, а не буква, вывести «цифра». Если символ не относится ни
к буквам, ни к цифрам, вывести «невозможно определить».
 */

import java.util.Scanner;
public class Task06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character - ");
        String input = sc.nextLine();

        if (input.length() != 1) {
            System.out.println("Please enter one character only!");
            return;
        }

        char ch = input.charAt(0);

        if (Character.isDigit(ch)) {
            System.out.println("Digit");
        } else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            System.out.println("Latin");
        } else if ((ch >= 'А' && ch <= 'я') || ch == 'Ё' || ch == 'ё') {
            System.out.println("Cyrillic");
        } else {
            System.out.println("Can't determine");
        }
    }
}
