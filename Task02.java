public class Task02 {
    public static void main(String[] args) {
        MainString s1 = new MainString();
        MainString s2 = new MainString("Hello there~");
        MainString s3 = new MainString('A');

        System.out.println("1st text length: " + s1.getLength());
        System.out.println("2d text length: " + s2.getLength());
        System.out.println("3d text length: " + s3.getLength());

        System.out.println("Index of the 'o' in text 2 is " + s2.indexOf('o'));

        s2.clear();
        System.out.println("After clearance, text 2 length is " + s2.getLength());
    }
}

class MainString {
    private char[] chars;
    private int length;

    // construct empty
    public MainString() {
        this.chars = new char[0];
        this.length = 0;
    }

    // construct
    public MainString(String str) {
        this.chars = str.toCharArray();
        this.length = chars.length;
    }

    // construct character
    public MainString(char c) {
        this.chars = new char[]{c};
        this.length = 1;
    }

    public int getLength() {
        return length;
    }

    public void clear() {
        this.chars = new char[0];
        this.length = 0;
    }

    // search for a string symbol
    public int indexOf(char c) {
        for (int i = 0; i < length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }
// redefinition
    @Override
    public String toString() {
        return new String(chars);
    }
}
