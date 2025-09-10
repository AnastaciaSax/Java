/*
Написать и протестировать перегруженный метод, выводящий на экран:
•	одномерный массив типа int;
•	одномерный массив типа String;
•	двухмерный массив типа int;
•	двухмерный массив типа float

 */
public class Task02 {
    // Overloaded method
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void printArray(String[] arr) {
        for (String val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(float[][] arr) {
        for (float[] row : arr) {
            for (float val : row) {
                System.out.printf("%8.2f", val); // element width + characters after ,
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Today we're playing with matrices!");
        int[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"Noah", "Cara", "Someone..."};
        int[][] intMatrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        float[][] floatMatrix = {
                {1.1f, 2.2f, 3.3f},
                {4.4f, 5.5f, 6.6f}
        };

        System.out.println("1D int array:");
        printArray(intArr);

        System.out.println("1D String array:");
        printArray(strArr);

        System.out.println("2D int array:");
        printArray(intMatrix);

        System.out.println("2D float array:");
        printArray(floatMatrix);
    }
}
