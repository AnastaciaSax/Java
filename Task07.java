/*
Написать программу, которая проверяет, все ли значения элементов массива одинаковые.
Вывести: Yes – если все одинаковы и No – если имеется хоть одно различие. Массив задается и
 инициализируется в начале программы.
 */
public class Task07 {
    public static void main(String[] args) {
        int[] array = {5, 5, 5, 5, 5, 5};

        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        boolean allEqual = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[0]) {
                allEqual = false;
                break;
            }
        }

        if (allEqual) {
            System.out.println("Yes");
        } else {
            System.out.println("NOO");
        }
    }
}
