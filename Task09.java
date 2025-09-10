/*
Создать квадратный массив размерности n заполненный случайными числами, вывести массив на экран в
виде таблицы, найти наименьший и наибольший элемент массива и вывести их на экран
(если найдено несколько одинаковых элементов – вывести индексы строка и столбца, где есть повторения).
Размерность массива должна задаваться с клавиатуры.
 */

import java.util.Random;
import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter square array size n - ");
        int n = scanner.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Array:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", array[i][j]); // 4 position string width
            }
            System.out.println();
        }

        int min = array[0][0];
        int max = array[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        System.out.println("Min element(s) at:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == min) {
                    System.out.println("Row: " + i + ", Column: " + j);
                }
            }
        }

        System.out.println("Max element(s) at:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == max) {
                    System.out.println("Row: " + i + ", Column: " + j);
                }
            }
        }

        scanner.close();
    }
}
