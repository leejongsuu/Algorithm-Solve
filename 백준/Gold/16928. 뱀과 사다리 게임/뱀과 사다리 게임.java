import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] board = new int[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int v) {

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);

        boolean[] visited = new boolean[101];
        visited[v] = true;

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int now = Q.poll();
                for (int j = 1; j <= 6; j++) {
                    int next = now + j;

                    if (next > 100) {
                        break;
                    }

                    if (board[next] == 100) {
                        return level + 1;
                    }

                    if (!visited[board[next]]) {
                        visited[board[next]] = true;
                        Q.offer(board[next]);
                    }
                }
            }
            level++;
        }
        return level;
    }
}

