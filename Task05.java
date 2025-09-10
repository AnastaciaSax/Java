public class Task05 {
        public static void main(String[] args) {
            MyArrayList<String> list = new MyArrayList<>();
            list.pushBack("One");
            list.pushBack("Two");
            list.pushBack("Three");
            list.pushBack("Four");

            System.out.println("Original list: " + list);

            // reverse
            list.reverse();
            System.out.println("After reverse: " + list);

            // shuffle
            list.shuffle();
            System.out.println("After shuffle: " + list);

            // getElementAt
            String element = list.getElementAt(1);
            System.out.println("Element at index 1: " + element);

            // clone
            MyArrayList<String> clonedList = list.clone();
            System.out.println("Cloned list: " + clonedList);

            // equals
            boolean isEqual = list.equals(clonedList);
            System.out.println("Original = cloned? " + isEqual);

            // change cloned list to test equals
            clonedList.pushBack("Five");
            System.out.println("After adding 'Five' to cloned: " + clonedList);
            System.out.println("Original = cloned yet? " + list.equals(clonedList));
        }
}
