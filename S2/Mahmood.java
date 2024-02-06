import java.util.Scanner;

public class Mahmood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int b[] = new int[n + 1];

        int x = scanner.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            b[u]++;
            b[v]++;

        }

        if (b[x] > 1) {

            if (n % 2 == 0) {
                System.out.println("Mahmood");
            } else {
                System.out.println("Shahrooz");

            }
        }else{
            System.out.println("Mahmood");

        }
    }

}
