import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int maxNode = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        DFS(1, 0);

        visited = new boolean[n + 1];
        DFS(maxNode, 0);

        System.out.println(maxDistance);
    }

    private static void DFS(int node, int distance) {
        visited[node] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = node;
        }
        for (Node next : tree.get(node)) {
            if (!visited[next.end]) {
                visited[next.end] = true;
                DFS(next.end, distance + next.weight);
            }
        }
    }
}
