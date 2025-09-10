/*
Подсчитать среднюю длину слова, во введенном с клавиатуры предложения.
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter something creative - ");
        String sentence = scanner.nextLine();

        // Split sentence into words
        String[] words = sentence.trim().split("\\s+");

        if (words.length == 0) {
            System.out.println("No words found");
        } else {
            int totalLength = 0;
            for (String word : words) {
                totalLength += word.length();
            }

            double averageLength = (double) totalLength / words.length;
            System.out.printf("Average word length is %.2f%n", averageLength);
        }

        scanner.close();
    }
}
