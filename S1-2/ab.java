
import java.util.Scanner;

public class ab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            a[i] = t;
            b[i]=t;
        }

        int sum=0;

        int max=0;
        for (int i = n-1 ; i >= 0; i--) {
            int temp = a[i];
            a[i] = Math.max(0 , max - a[i]);
            max = Math.max(temp , max);
        }
        max=0;
        for (int i = 0; i<=n-1; i++) {
            int temp = b[i];
            b[i] = Math.max(0 , max - b[i]);
            max = Math.max(temp , max);
            sum+=Math.min(a[i],b[i]);
        }

        System.out.println(sum);
    }
}
