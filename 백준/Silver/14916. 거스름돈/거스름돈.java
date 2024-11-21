import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int INF = 100001;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] coin = new int[]{5, 2};

        Arrays.fill(arr, INF);
        arr[0] = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = coin[i]; j <= n; j++) {
                arr[j] = Math.min(arr[j], arr[j - coin[i]] + 1);
            }
        }

        System.out.println(arr[n] == INF ? -1 : arr[n]);
    }
}