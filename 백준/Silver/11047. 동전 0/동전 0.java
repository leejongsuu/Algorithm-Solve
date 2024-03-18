import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] coin;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int total = Integer.parseInt(input[1]);

        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int i = N - 1;
        while (total > 0) {
            if (coin[i] <= total) {
                cnt += total / coin[i];
                total %= coin[i];
            } else {
                i--;
            }
        }
        System.out.println(cnt);
    }
}