import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int N, M, X;
    static List<Node>[] adj, r_adj;

    static final int INF = 100 * 10000 + 1;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        r_adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            r_adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new Node(to, cost));
            r_adj[to].add(new Node(from, cost));
        }

        int[] go = dijkstra(adj, X);
        int[] back = dijkstra(r_adj, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(go[i] + back[i], max);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(List<Node>[] lists, int x) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        queue.add(new Node(x, 0));
        dist[x] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int next = current.v;

            for (Node node : lists[next]) {
                if (dist[node.v] > dist[next] + node.w) {
                    dist[node.v] = dist[next] + node.w;
                    queue.add(new Node(node.v, dist[node.v]));
                }
            }
        }

        return dist;
    }
}