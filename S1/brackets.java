import java.util.Scanner;
import java.util.Stack;

public class brackets {
    static Stack<Character> stack = new Stack<>();
    public static String isBalanced(String s1) {

            stack.push(s1.charAt(0));
            for (int i = 1; i <= s1.length()-1; i++) {
                if(stack.isEmpty()&&(s1.charAt(i) == ')' || s1.charAt(i) == ']' || s1.charAt(i) == '}')){
                    return "NO";
                }
                if (s1.charAt(i) == '(' || s1.charAt(i) == '{' || s1.charAt(i) == '[') {
                    stack.push(s1.charAt(i));
                } else {
                    if (stack.peek() + 1 == s1.charAt(i) || stack.peek() + 2 == s1.charAt(i)) {
                        stack.pop();
                    }
                }
            }

        if (stack.isEmpty()) {
            return "YES";
        }
        stack.removeAllElements();
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String sen = scanner.nextLine();
            System.out.println(isBalanced(sen));
        }
    }
}
