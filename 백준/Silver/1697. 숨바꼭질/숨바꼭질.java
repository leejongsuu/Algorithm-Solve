import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int n, int k) {

        boolean[] visited = new boolean[100001];
        visited[n] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();

                if (now == k) {
                    return level;
                }

                if (now - 1 >= 0 && !visited[now - 1]) {
                    visited[now - 1] = true;
                    queue.offer(now - 1);
                }

                if (now < k) {
                    if (!visited[now + 1]) {
                        visited[now + 1] = true;
                        queue.offer(now + 1);
                    }
                    if (2 * now < 100001 && !visited[2 * now]) {
                        visited[2 * now] = true;
                        queue.offer(2 * now);
                    }
                }
            }
            level++;
        }

        return level;
    }
}