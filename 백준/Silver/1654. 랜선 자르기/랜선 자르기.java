import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long solution(int k, int n, long max, int[] arr) {

        //반드시 max에서 +1 값이어야 함.
        max++;

        long min = 1;
        long mid;

        while (min < max) {

            mid = (max + min) / 2;

            long count = 0;

            for (int i = 0; i < k; i++) {
                count += (arr[i] / mid);
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(solution(K, N, max, arr));
    }
}