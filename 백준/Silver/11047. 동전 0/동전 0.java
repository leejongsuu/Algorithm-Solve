import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int solution(int n, int k, int[] coin) {

        int cnt = 0;
        for (int i = n - 1; k > 0 && i >= 0; i--) {
            
            if (coin[i] > k) continue;
            cnt += k / coin[i];
            k %= coin[i];
        }
        return cnt;
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