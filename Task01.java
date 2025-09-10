/*
Написать класс-контейнер, реализующий логику работы одномерного безразмерного динамического массива.
Обработать исключительные ситуации.

Имя класса MyArrayList.
Структура данных – массив.
Типы хранимых данных – объекты любых классов (использовать шаблонное программирование).
В классе должно быть три поля:
 - ссылка на инкапсулированный массив (можно назвать data);
-  текущее количество существующих элементов в массиве (int size);
-  текущая емкость массива ( int capacity, по умолчанию 10)

 */
public class Task01 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        try {
            list.remove(0);
        } catch (EmptyListException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        try {
            list.add("Apple");
            list.add("Banana");
            list.add("Cherry");

            System.out.println("List size - " + list.size());
            System.out.println("Element at index 1 - " + list.get(1));list.remove(0);
            System.out.println("After removing 1st element:");
            list.printAll();

            // invoke index except
            System.out.println(list.get(10));

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (EmptyListException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}