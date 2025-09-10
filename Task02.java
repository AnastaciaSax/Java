/*
Создать два конструктора.
•	С параметром типа int. Задающего начальную емкость массива. Принимает один параметр (задает capacity),
 выделяет память под массив (size = 0).
•	По умолчанию (без параметров). Который выделяет память под массив на 10 элементов, равных нулю
(capacity = 10, size = 0). Переиспользовать конструктор с параметрами для уменьшения кода.

 */
public class Task02 {
    public static void main(String[] args) {
        // 1
        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");

        System.out.println("List1 size - " + list1.size());
        System.out.println("Element at index 1 - " + list1.get(1));
        list1.remove(0);
        System.out.println("After removing 1st element:");
        list1.printAll();

        // 2
        MyArrayList<Integer> list2 = new MyArrayList<>(5);
        list2.add(10);
        list2.add(20);
        System.out.println("List2 size - " + list2.size());
        list2.printAll();

        // 3
        try {
            MyArrayList<String> emptyList = new MyArrayList<>();
            emptyList.remove(0);
        } catch (EmptyListException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.println(list1.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
