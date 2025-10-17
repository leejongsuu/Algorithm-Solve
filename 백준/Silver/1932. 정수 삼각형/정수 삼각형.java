import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c <= r; c++) {
                dp[r + 1][c] = Math.max(dp[r + 1][c], dp[r][c] + arr[r + 1][c]);
                dp[r + 1][c + 1] = Math.max(dp[r + 1][c + 1], dp[r][c] + arr[r + 1][c + 1]);
            }
        }

        int max = Arrays.stream(dp[N - 1]).max().getAsInt();

        System.out.println(max);
    }
}