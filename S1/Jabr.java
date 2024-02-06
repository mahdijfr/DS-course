import java.util.Stack;
import java.util.Scanner;

public class Jabr
{
    public static boolean isdigit(char x){
        return x >= '0' && x <= '9';
    }
    






    public static Integer calculate(char op, Integer b, Integer a)
    {
        a = a % 1000000007;
        b = b % 1000000007;
        if (op == '+')
            return (a + b) % 1000000007;
        if (op == '-')
            return (a - b) % 1000000007;
        if (op == '*')
            return (int)(((long)a * (long)b) % 1000000007);
        
        return 0;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        char[] expression = scanner.nextLine().toCharArray();

        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < expression.length; i++)
        {

            if (isdigit(expression[i]))
            {
                StringBuffer sbuf = new StringBuffer();

                while (i < expression.length && isdigit(expression[i])) sbuf.append(expression[i++]);
                values.push(Integer.parseInt(sbuf.toString()) % 1000000007);

                i--;
            }

            else if (expression[i] == '(')
                ops.push(expression[i]);

            else if (expression[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(calculate(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/')
            {

                while (!ops.empty() && (!((ops.peek() == '(' || ops.peek() == ')') || (((expression[i] == '*' || expression[i] == '/') && (ops.peek() == '+' || ops.peek() == '-'))) )))
                    values.push(calculate(ops.pop(), values.pop(), values.pop()));

                ops.push(expression[i]);
            }
        }
        while (!ops.empty())
            values.push(calculate(ops.pop(), values.pop(), values.pop()));


        Integer result = values.pop() % 1000000007;
        if (result < 0)
            result += 1000000007;
        System.out.println(result);
        scanner.close();
    }
}
