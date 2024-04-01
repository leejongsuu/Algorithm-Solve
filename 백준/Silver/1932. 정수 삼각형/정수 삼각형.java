import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    dp[i][j] = num;
                } else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + num;
                    } else if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1] + num;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                    }
                }
            }
        }

        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dp[N - 1][i]);
        }

        System.out.println(maxSum);
    }
}