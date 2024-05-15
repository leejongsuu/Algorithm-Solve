import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static final int INF = 300000 * 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
        }

        int[] dist = new int[V + 1];
        dijkstra(K, dist, graph);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] >= INF) sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
        }

        System.out.print(sb);
    }

    private static void dijkstra(int start, int[] dist, ArrayList<ArrayList<Node>> graph) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentEnd = current.end;
            int currentWeight = current.weight;

            if (dist[currentEnd] < currentWeight) continue;

            for (Node next : graph.get(currentEnd)) {
                int newDist = dist[currentEnd] + next.weight;
                if (newDist < dist[next.end]) {
                    dist[next.end] = newDist;
                    pq.offer(new Node(next.end, newDist));
                }
            }
        }
    }
}
