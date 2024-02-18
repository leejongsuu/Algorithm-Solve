import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public int solution(int n, int[] arr) {

        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        int[] di = {3, 5};
        for (int i = 0; i < di.length; i++) {

            for (int j = di[i]; j <= n; j++) {
                if (arr[j - di[i]] == Integer.MAX_VALUE) continue;
                arr[j] = Math.min(arr[j], arr[j - di[i]] + 1);
            }
        }

        return arr[n] == Integer.MAX_VALUE ? -1 : arr[n];
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        System.out.println(T.solution(N, arr));
    }
}