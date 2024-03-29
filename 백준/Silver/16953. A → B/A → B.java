import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        System.out.println(BFS(N, M));
    }

    static long BFS(long n, long m) {

        Queue<Long> Q = new LinkedList<>();
        Q.offer(n);

        int level = 1;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                long now = Q.poll();

                long num1 = Func1(now);
                long num2 = Func2(now);

                if (num1 == m || num2 == m) {
                    return level + 1;
                }

                if (num1 < m) {
                    Q.offer(num1);
                }

                if (num2 < m) {
                    Q.offer(num2);
                }
            }
            level++;
        }
        return -1;
    }

    static long Func1(long n) {
        return (2L * n);
    }

    static long Func2(long n) {
        return (10L * n + 1);
    }
}