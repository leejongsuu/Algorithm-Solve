import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N + 1];
        int[] di = new int[N + 1];
        int sum = 0;

        String[] value = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(value[i - 1]);
            sum += arr[i];
            di[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int hi = Integer.parseInt(input2[1]);
            int lo = Integer.parseInt(input2[0]);
            sb.append(di[hi] - di[lo - 1]).append('\n');
        }

        System.out.println(sb);
    }
}