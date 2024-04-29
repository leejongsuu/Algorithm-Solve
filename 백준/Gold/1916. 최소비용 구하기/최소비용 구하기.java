import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발 도시
            int v = Integer.parseInt(st.nextToken()); // 도착 도시
            int w = Integer.parseInt(st.nextToken()); // 비용
            graph.get(u).add(new Node(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 구하고자 하는 구간의 출발 도시 번호
        int end = Integer.parseInt(st.nextToken()); // 도착 도시 번호

        int[] minCost = dijkstra(N, graph, start);
        System.out.println(minCost[end]);
    }

    private static int[] dijkstra(int N, List<List<Node>> graph, int start) {
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (costs[current.vertex] < current.weight) continue;

            for (Node next : graph.get(current.vertex)) {
                if (costs[next.vertex] > costs[current.vertex] + next.weight) {
                    costs[next.vertex] = costs[current.vertex] + next.weight;
                    pq.offer(new Node(next.vertex, costs[next.vertex]));
                }
            }
        }

        return costs;
    }

    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
