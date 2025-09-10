/*
Числа Фибоначчи – это последовательность чисел, в которой два первых числа последовательности равны
0 и 1, а каждое последующее число равно сумме двух предыдущих.
Показать на экране все числа Фибоначчи в диапазоне от 0 до 10 000 000

 */
public class Task01 {
    public static void main(String[] args) {
        System.out.println("A great day to crunch numbers, so shall we? \nFibonacci nums up to 10.000.000:");

        int a = 0;
        int b = 1;

        while (a <= 10000000) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}