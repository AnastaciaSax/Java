import java.util.Scanner;

public class Task07 {
    public static void main (String[] args){
    Scanner scan = new Scanner(System.in);

        System.out.print("Enter a positive integer - ");
    long number = scan.nextLong();
    long reversed = 0;

        while (number > 0) {
        long digit = number % 10;      // last
        reversed = reversed * 10 + digit; // to the start
        number /= 10;                  // remove last
    }

        System.out.println("Reversed number is " + reversed);
        scan.close();
}
}
