/*
•	Напишите метод, проверяющую правильность расстановки скобок в строке, введенной с клавиатуры.
 При правильной расстановке выполняются условия: количество открывающих и закрывающих скобок равно;
•	внутри любой пары открывающая–соответствующая закрывающая скобка, скобки расставлены правильно.
В строке могут присутствовать как круглые, так и квадратные скобки (и др. символы). Каждой открывающей
 скобке соответствует закрывающая того же типа (круглой – круглая, квадратной – квадратная).

 */

import java.util.Scanner;
import java.util.Stack; // adds, deletes elements. "Last comes, 1st to go"

public class Task04 {
    public static String checkBrackets(String input) {
        Stack<Character> stack = new Stack<>(); // heap

        for (char ch : input.toCharArray()) {
            // If opening bracket, push to stack
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket, check stack
            else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return "ERROR! extra closing bracket " + ch;
                }
                char open = stack.pop();
                if (ch == ')' && open != '(') {
                    return "ERROR! missing ( before )";
                }
                if (ch == ']' && open != '[') {
                    return "ERROR! missing [ before ]";
                }
            }
        }

        if (!stack.isEmpty()) {
            char open = stack.peek();
            if (open == '(') {
                return "ERROR! missing )";
            } else if (open == '[') {
                return "ERROR! missing ]";
            }
        }

        return "Alright to go!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text using brackets - ");
        String input = scanner.nextLine();

        String result = checkBrackets(input);
        System.out.println(result);
    }
}
