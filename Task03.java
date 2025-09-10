import java.util.Scanner;
public class Task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pick animal:");
        System.out.println("1 - Cat");
        System.out.println("2 - Dog");
        System.out.println("3 - Cow");
        System.out.println("4 - Sheep");
        System.out.println("5 - Horse");
        System.out.println("6 - Pig");
        System.out.println("7 - Duck");
        System.out.println("8 - Chicken");
        System.out.println("9 - Lion");
        System.out.println("10 - Frog");

        System.out.print("Enter number - ");
        int choice = sc.nextInt();

        String sound;
        switch (choice) {
            case 1:
                sound = "Meow!";
                break;
            case 2:
                sound = "Woof!";
                break;
            case 3:
                sound = "Moo!";
                break;
            case 4:
                sound = "Baa!";
                break;
            case 5:
                sound = "Neigh!";
                break;
            case 6:
                sound = "Oink!";
                break;
            case 7:
                sound = "Quack!";
                break;
            case 8:
                sound = "Cluck!";
                break;
            case 9:
                sound = "ROAR!";
                break;
            case 10:
                sound = "Ribbit!";
                break;
            default:
                sound = "ERROR! Check the list";
        }

        System.out.println(sound);
    }
}
