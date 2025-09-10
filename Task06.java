import java.util.Random;

public class Task06 {
    public static void main(String[] args) {
        int[] array = new int[30];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(121) - 70; // nextInt generates 0..120, minus 70 gives -70..50
        }

        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int min = array[0];
        int max = array[0];

        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Min element is " + min);
        System.out.println("Max one is " + max);
    }
}
