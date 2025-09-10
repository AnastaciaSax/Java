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
