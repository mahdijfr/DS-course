import java.io.*;
import java.util.*;

public class fast {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int[] a = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = fastReader.nextInt();
            a[i] = num;
        }
        int[] ansL = new int[n];
        int[] ansR = new int[n];
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            if (s.isEmpty())
                ansL[i] = 0;
            else
                ansL[i] = s.peek() + 1;
            s.push(i);
        }
        s.clear();
        s.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            if (s.isEmpty())
                ansR[i] = 0;
            else
                ansR[i] = s.peek() + 1;
            s.push(i);
        }

        for (int i = 0; i < n; i++)
            bufferedWriter.write(ansL[i] + " " + ansR[i] + "\n");

        bufferedWriter.flush();

    }
}