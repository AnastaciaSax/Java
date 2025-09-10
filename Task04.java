import java.util.Scanner;
public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter what's on your mind - ");
        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch)); //add
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isDigit(ch)) {
                result.append('_');
            } else {
                result.append(ch); // leave other characters unchanged
            }
        }

        System.out.println("Well I've decided to change it a bit: " + result.toString());
        scanner.close();
    }
}
