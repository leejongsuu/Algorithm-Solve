import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Counsel {
        int index;
        int t, p;

        Counsel(int index, int t, int p) {
            this.index = index;
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Counsel[] counsels = new Counsel[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            counsels[i] = new Counsel(i, t, p);
        }

        Queue<Counsel> queue = new LinkedList<>();
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {

            if (dp[i] >= counsels[i].p || i + counsels[i].t > N + 1) {
                continue;
            }

            dp[i] = counsels[i].p;
            queue.offer(counsels[i]);

            while (!queue.isEmpty()) {
                Counsel current = queue.poll();

                for (int j = current.index + current.t; j <= N; j++) {
                    Counsel next = counsels[j];
                    if (next.index + next.t <= N + 1) {
                        if (dp[j] < dp[current.index] + next.p) {
                            dp[j] = dp[current.index] + next.p;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}