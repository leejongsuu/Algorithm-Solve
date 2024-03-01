import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] relation;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        relation = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            relation[s][e] = 1;
            relation[e][s] = 1;
        }

        int minValue = BFS(1);
        int result = 1;

        for (int i = 2; i <= N; i++) {
            int bfs = BFS(i);
            if (bfs < minValue) {
                minValue = bfs;
                result = i;
            }
        }

        System.out.println(result);
    }

    static int BFS(int v) {

        Queue<Integer> Q = new LinkedList<>();

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        Q.offer(v);
        visited[v] = true;

        int sum = 0;

        while (!Q.isEmpty()) {
            int current = Q.poll();

            for (int i = 1; i <= N; i++) {
                if (relation[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    Q.offer(i);
                    distance[i] = distance[current] + 1;
                    sum += distance[i];
                }
            }
        }

        return sum;
    }
}