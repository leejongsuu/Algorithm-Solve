import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int size = 100001;
        boolean[] visited = new boolean[size];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(N);

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int current = Q.poll();
                if (K == current) {
                    System.out.println(level);
                    break;
                } else {
                    if (current - 1 >= 0 && !visited[current - 1]) {
                        Q.offer(current - 1);
                        visited[current - 1] = true;
                    }

                    if (current < K) {
                        if (current != 0 && 2 * current <= size && !visited[2 * current]) {
                            Q.offer(2 * current);
                            visited[2 * current] = true;
                        }
                        if (current + 1 <= size && !visited[current + 1]) {
                            visited[current + 1] = true;
                            Q.offer(current + 1);
                        }
                    }
                }
            }
            level++;
        }
    }
}