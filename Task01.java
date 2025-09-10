/*
Написать программу, которая предлагает пользователю ввести c клавиатуры номер дня недели, и в ответ
 показывает название этого дня (например, 6 – это суббота). Решить с использованием switch.
 */

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter week day number - ");
        int num = sc.nextInt();

        System.out.print("It's...");
        String day;
        switch (num) {
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                day = "ERROR! Check the number, it's within 7";
        }

        System.out.println(day);
    }
}