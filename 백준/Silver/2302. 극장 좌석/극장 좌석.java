import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] fixed = new int[M];
        for (int i = 0; i < M; i++) {
            fixed[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1];

        List<Integer> list = new ArrayList<>();
        int before = 0;
        for (int i = 0; i < M; i++) {
            int n = fixed[i] - before - 1;
            list.add(fibo(n));
            before = fixed[i];
        }
        list.add(fibo(N - before));

        int result = 1;
        for (int i : list) {
            result *= i;
        }

        System.out.println(result);
    }

    private static int fibo(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibo(n - 1) + fibo(n - 2);
    }
}


---
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int result = 1;
        int start = 0;
        for (int i = 0; i < M; i++) {
            int len = vip[i] - start - 1;
            result *= dp[len];
            start = vip[i];
        }
        result *= dp[N - start];

        System.out.println(result);
    }
}
