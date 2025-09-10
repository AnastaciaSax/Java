import java.util.Random;
    // Generic (pattern) dynamic array class
    public class MyArrayList<T> { // T - a future type
        private Object[] data;
        private int size; // now
        private int capacity; //overall

        // construct
        public MyArrayList() {
            this(10);
        }
        public MyArrayList(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be > 0");
            }
            this.capacity = capacity;
            this.data = new Object[capacity];
            this.size = 0;
        }

        public void add(T element) {
            ensureCapacity(size + 1);
            data[size++] = element;
        }

        @SuppressWarnings("unchecked") // we tell compiler there's a type needed (even if not Object)
        public T get(int index) {
            checkIndex(index);
            return (T) data[index];
        }

        public void remove(int index) {
            if (size == 0) {
                throw new EmptyListException("Cannot remove from an empty list");
            }
            checkIndex(index);
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[--size] = null;
        }

        public int size() {
            return size;
        }

        public void printAll() {
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        private void grow() {
            capacity = capacity * 2;
            Object[] newData = new Object[capacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(
                        "Index " + index + " out of bounds for size " + size
                );
            }
        }
        //redefinition
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(data[i]);
                if (i < size - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        private void ensureCapacity(int minCapacity) {
            if (minCapacity > capacity) {
                capacity = capacity * 3 / 2 + 1;
                if (capacity < minCapacity) {
                    capacity = minCapacity;
                }
                Object[] newData = new Object[capacity];
                System.arraycopy(data, 0, newData, 0, size);
                data = newData;
            }
        }
        //3
        public void pushBack(T element) {
            add(element); // ensureCapacity
        }

        public T popFront() {
            if (size == 0) throw new EmptyListException("List's empty");
            T removed = get(0);
            remove(0);
            return removed;
        }

        public void pushFront(T element) {
            ensureCapacity(size + 1);
            for (int i = size; i > 0; i--) {
                data[i] = data[i - 1];
            }
            data[0] = element;
            size++;
        }

        public void insert(int index, T element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
            }
            ensureCapacity(size + 1);
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = element;
            size++;
        }

        public void removeAt(int index) {
            remove(index);
        }

        public boolean remove(T element) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(element)) {
                    remove(i);
                    return true;
                }
            }
            return false;
        }

        public int removeAll(T element) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (data[i].equals(element)) {
                    remove(i);
                    i--;
                    count++;
                }
            }
            return count;
        }

        public T popBack() {
            if (size == 0) throw new EmptyListException("List's empty");
            T removed = get(size - 1);
            data[--size] = null;
            return removed;
        }

        public void clear() {
            for (int i = 0; i < size; i++) {
                data[i] = null;
            }
            size = 0;
        }
        //5
        public void reverse() {
            for(int i=0;i<size/2;i++){
                Object temp = data[i];
                data[i] = data[size-1-i];
                data[size-1-i] = temp;
            }
        }

        public void shuffle() { // mess it up
            Random rand = new Random();
            for(int i=size-1;i>0;i--){
                int j = rand.nextInt(i+1);
                Object temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        public boolean equals(MyArrayList<T> other){
            if(other==null || this.size!=other.size()) return false;
            for(int i=0;i<size;i++){
                if(!data[i].equals(other.data[i])) return false;
            }
            return true;
        }

        // getElementAt (copy)
        @SuppressWarnings("unchecked") // for T. Don't worry about type
        public T getElementAt(int index){
            checkIndex(index);
            T element = (T) data[index];

            if(element instanceof Cloneable){
                try {
                    return (T) element.getClass().getMethod("clone").invoke(element);
                } catch (Exception e){
                    // original
                    return element;
                }
            }
            return element;
        }

        @Override
        @SuppressWarnings("unchecked")
        public MyArrayList<T> clone(){
            MyArrayList<T> copy = new MyArrayList<>(this.capacity);
            for(int i=0;i<size;i++){
                copy.data[i] = this.data[i];
            }
            copy.size = this.size;
            return copy;
        }
    }
