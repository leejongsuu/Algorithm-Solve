import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N + 1];
        int[] points = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            points[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];

        for (int i = N; i > 0; i--) {
            int nextDay = i + times[i];

            if (nextDay > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], points[i] + dp[nextDay]);
            }
        }

        System.out.println(dp[1]);
    }
}