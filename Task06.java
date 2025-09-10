public class Task06 {
    public static void main(String[] args) {
        System.out.println("Hey, let's brush up on counting till 1.000!");
        System.out.println("Actually my mind's a bit melting today... Nevermind!");
        System.out.println("So nums from 1 to 1.000:");

        for (int i = 1; i <= 1000; i++) {
            if (i % 15 == 0) {
                System.out.println("hiss");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
