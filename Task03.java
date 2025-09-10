/*
Реализовать методы:
•	геттеры для size. Сеттера для size не должно быть!
•	переопределить метод toString и реализовать строковое представление элементов массива через пробел.
•	ensureCapacity – закрытый метод! проверяет, достаточно ли резерва памяти для хранения указанного в
параметре количества элементов. Если значение параметра меньше текущего capacity, то ничего не происходит.
Если значение параметра больше текущего capacity, то массив пересоздается, памяти выделяется в 1,5 раза + 1
 элемент больше. Существующие элементы переносятся в новый массив. Существующие элементы не должны быть
 потеряны.

 */
public class Task03 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>(3);

        list.add("One");
        list.add("Two");
        list.add("Three");
        System.out.println("Before expansion:");
        System.out.println("Size: " + list.size());
        System.out.println("List: " + list.toString());

        //  ensureCapacity
        list.add("Four");

        System.out.println("\nAfter expansion:");
        System.out.println("Size: " + list.size());
        System.out.println("List: " + list.toString());
    }
}
