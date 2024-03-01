import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        System.out.println(BFS(N, M));
    }

    static int BFS(int n, int m) {

        int size = 100001;
        boolean[] visited = new boolean[size];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {

                int current = Q.poll();
                visited[current] = true;

                if (current == m) {
                    return level;
                } else {
                    if (current - 1 >= 0 &&!visited[current-1]) {
                        Q.offer(current - 1);
                    }
                    if (current < m) {
                        if (current != 0 && (current * 2 <= size) &&!visited[current*2]) {
                            Q.offer(2 * current);
                        }
                        if (current + 1 <= size && !visited[current + 1]) {
                            Q.offer(current + 1);
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
}