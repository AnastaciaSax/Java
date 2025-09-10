import java.util.Random;
import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter array size n - ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // -2 < n
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n + 3) - 2; // -2..n
        }

        System.out.print("Initial array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Check for negative values < -1
        boolean hasNegativeLessThanMinusOne = false;
        for (int num : array) {
            if (num < -1) {
                hasNegativeLessThanMinusOne = true;
                break;
            }
        }

        // replace negative numbers with their squares
        if (hasNegativeLessThanMinusOne) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 0) {
                    array[i] = array[i] * array[i];
                }
            }
        }

        System.out.print("Final5 array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
