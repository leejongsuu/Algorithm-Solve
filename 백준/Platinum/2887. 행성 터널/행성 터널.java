import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v1, v2, w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int N = Integer.parseInt(br.readLine());
        int[][] x = new int[N][2];
        int[][] y = new int[N][2];
        int[][] z = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i][0] = i;
            y[i][0] = i;
            z[i][0] = i;

            x[i][1] = Integer.parseInt(st.nextToken());
            y[i][1] = Integer.parseInt(st.nextToken());
            z[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(y, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(z, Comparator.comparingInt(a -> a[1]));

        unf = new int[N];
        for (int i = 0; i < N; i++) {
            unf[i] = i;
        }

        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            graph.add(new Edge(x[i][0], x[i + 1][0], Math.abs(x[i + 1][1] - x[i][1])));
            graph.add(new Edge(y[i][0], y[i + 1][0], Math.abs(y[i + 1][1] - y[i][1])));
            graph.add(new Edge(z[i][0], z[i + 1][0], Math.abs(z[i + 1][1] - z[i][1])));
        }

        Collections.sort(graph);

        for (Edge edge : graph) {
            int v1 = edge.v1;
            int v2 = edge.v2;

            if (find(v1) == find(v2)) {
                continue;
            }

            result += edge.w;
            union(v1, v2);
        }

        System.out.println(result);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }
}