import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr[i][0] = W;
            arr[i][1] = V;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[K + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = K; j - arr[i][0] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
            }
        }

        System.out.println(dp[K]);
    }
}