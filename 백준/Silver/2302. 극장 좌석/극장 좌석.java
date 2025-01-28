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