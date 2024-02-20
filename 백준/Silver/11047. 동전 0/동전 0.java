import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int solution(int n, int k, int[] coin) {
        int[] arr = new int[k + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                arr[j] = Math.min(arr[j], arr[j - coin[i]] + 1);
            }
        }
        return arr[k];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, K, coin));
    }
}