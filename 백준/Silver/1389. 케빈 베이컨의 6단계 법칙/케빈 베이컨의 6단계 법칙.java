import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            int count = bfs(i);
            if (count < min) {
                min = count;
                result = i;
            }
        }

        System.out.println(result);
    }

    public static int bfs(int v) {

        boolean[] visited = new boolean[N + 1];
        visited[v] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        int sum = 0;
        int level = 1;
        int population = 1;
        while (!queue.isEmpty() && population < N) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        sum += level;
                        queue.offer(next);
                    }
                }
            }

            level++;
        }

        return sum;
    }
}