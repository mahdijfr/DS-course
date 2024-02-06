import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> a = new Stack<>();
        Queue<Integer> b = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num1 = scanner.nextInt();
            a.push(num1);
        }
        for (int i = 0; i < n; i++) {
            int num2 = scanner.nextInt();
            b.add(num2);
        }
        for (int i = 0; i < n; i++) {
            s.push(a.get(i));
            while (!s.isEmpty()&&s.peek() == b.peek()) {
                    s.pop();
                    b.remove();

            }
        }

        if (s.isEmpty()){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }


    }
}
