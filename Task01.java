/*
Ввести с клавиатуры строку текста, а затем один символ. Показать на консоль индексы и количество совпадений
(ищем вхождения символа в строку). В случае если совпадений не найдено, вывести соответствующий текст.
 */

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text - ");
        String text = scanner.nextLine();

        // Input a single character
        System.out.print("Enter a character to search for - ");
        String inputChar = scanner.nextLine();

        // Check input validity
        if (inputChar.length() != 1) {
            System.out.println("ERROR! Please enter 1 character!");
            return;
        }

        char ch = inputChar.charAt(0);
        int count = 0;

        System.out.print("Character found at: ");
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                System.out.print(i + " ");
                count++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNothing found with a '" + ch + "' in the text. Sorry");
        } else {
            System.out.println("\nTotal: " + count);
        }

        scanner.close();
    }

}