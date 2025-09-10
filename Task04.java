/*
Реализовать методы:
•	pushBack (добавление элемента в конец массива. Должна быть проверка, достаточно ли памяти!
Если памяти не достаточно увеличить емкость массива данных);
•	popFront (удаление первого элемента из массива);
•	pushFront (добавление нового элемента в начало массива);
•	insert (вставка нового элемента в массив по указанному индексу, с проверкой на выход за пределы массива);
•	removeAt (удаление одного элемента по указанному индексу. Должна быть проверка на допустимость индекса);
•	remove (удаление одного элемента, значение которого совпадает со значением переданного параметра);
•	removeAll (удаление всех элементов, значения которых совпадает со значением переданного параметра);
•	popBack (удаление последнего элемента из массива);
•	сlear (обнуление массива – всем элементам массива по индексам от 0 до size-1 присвоить значение null,
 полю size присвоить значение 0).

 */
public class Task04 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        System.out.println("1 pushBack");
        list.pushBack("A");
        list.pushBack("B");
        list.pushBack("C");
        System.out.println(list);

        System.out.println("\n2 pushFront");
        list.pushFront("Start");
        System.out.println(list);

        System.out.println("\n3 insert");
        list.insert(2, "Middle");
        System.out.println(list);

        System.out.println("\n4 removeAt");
        list.removeAt(2);
        System.out.println(list);

        System.out.println("\n5 remove (1st occurrence)");
        list.remove("B");
        System.out.println(list);

        System.out.println("\n6 removeAll");
        list.pushBack("C");
        list.pushBack("C");
        System.out.println("Before removeAll: " + list);
        list.removeAll("C");
        System.out.println("After removeAll: " + list);

        System.out.println("\n7 popFront");
        String front = list.popFront();
        System.out.println("Removed: " + front);
        System.out.println(list);

        System.out.println("\n8 popBack");
        String back = list.popBack();
        System.out.println("Removed: " + back);
        System.out.println(list);

        System.out.println("\n9 clear");
        list.clear();
        System.out.println("After clearance, size = " + list.size());
        System.out.println(list);
    }
}
