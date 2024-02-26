import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[i]는 i를 표현하는데 필요한 최소 제곱수의 개수를 저장하는 배열
        int[] dp = new int[n + 1];

        // dp 배열 초기화
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // i를 1의 제곱수로만 표현할 경우 필요한 제곱수의 개수는 i개
            for (int j = 1; j * j <= i; j++) {
                // i보다 작은 제곱수들을 하나씩 시도하면서 최소값을 찾음
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
