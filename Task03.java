/*
Самовлюблённое число или число Армстронга – натуральное число, которое равно сумме своих цифр,
возведенных в степень, равную количеству его цифр. Показать на экране все числа Армстронга в диапазоне
 от 10 до 1 000 000.
Например: 153 = 13 + 53 + 33

 */
public class Task03 {
    private static boolean isArmstrong(int n) {
        String numStr = Integer.toString(n);
        int length = numStr.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            int digit = numStr.charAt(i) - '0';   // extract digit
            sum += Math.pow(digit, length);
        }

        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println("Armstrong nums 10 < 1.000.000:");

        for (int number = 10; number <= 1000000; number++) {
            if (isArmstrong(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
