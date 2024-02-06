
import java.util.*;

public class raz {

    private static int BFS(ArrayList<ArrayList<Integer>> graph, int s, int t, int v) {

        Queue<Integer> q = new LinkedList<>();
        int[] d = new int[v+1];
        Arrays.fill(d, 1000000);
        boolean[] visited = new boolean[v+1];

        for (int i = 0; i <= v; i++) {
            visited[i] = false;
        }
        d[t] = 0;
        q.add(t);
        visited[t] = true;

        while (!q.isEmpty()) {
            int m = q.remove();
            for (int i = 0; i < graph.get(m).size(); i++) {
                if (!visited[graph.get(m).get(i)]) {
                    q.add(graph.get(m).get(i));
                    d[graph.get(m).get(i)] = d[m] + 1;

                    visited[graph.get(m).get(i)] = true;
                    if (graph.get(m).get(i) == s)

                        return d[s];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,r,s,t,u,v;
        int T = scanner.nextInt();
//        int[] answer = new int[T];

        for (int l = 0; l < T; l++) {
             n = scanner.nextInt();
             r = scanner.nextInt();
             s = scanner.nextInt();
             t = scanner.nextInt();


            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
            graph.clear();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < r; i++) {
                 v = scanner.nextInt();
                 u = Integer.parseInt(scanner.next());
                graph.get(v).add(u);

            }
            System.out.println(BFS(graph, s, t, n));

//            for (int i = 1; i <= n; i++) {
//                System.out.println(graph.get(i));
//
//            }
        }
//        for (int i = 0; i < T; i++) {
//            System.out.println(answer[i]);
//
//        }

    }
}
