import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] dp = new int[N];
        int[] dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] > sequence[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }

        dp2[N - 1] = 1;
        for (int i = N - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if (sequence[i] > sequence[j] && dp2[j] > max) {
                    max = dp2[j];
                }
            }
            dp2[i] = max + 1;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] + dp2[i] > max) {
                max = dp[i] + dp2[i];
            }
        }

        System.out.println(max - 1);
    }
}