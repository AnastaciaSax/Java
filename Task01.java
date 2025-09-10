
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