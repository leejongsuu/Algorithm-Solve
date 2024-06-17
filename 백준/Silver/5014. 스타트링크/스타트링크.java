import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int result = BFS(F, S, G, U, D);
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    private static int BFS(int f, int s, int g, int u, int d) {

        boolean[] visited = new boolean[f + 1];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == g) return level;

                int nextUp = current + u;
                if (nextUp <= f && !visited[nextUp]) {
                    visited[nextUp] = true;
                    queue.offer(nextUp);
                }

                int nextDown = current - d;
                if (nextDown > 0 && !visited[nextDown]) {
                    visited[nextDown] = true;
                    queue.offer(nextDown);
                }
            }
            level++;
        }

        return -1;
    }
}


