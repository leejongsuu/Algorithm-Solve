import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] strArr = br.readLine().toCharArray();
        int[] memo = new int[M];
        int ans = 0;

        for (int i = 1; i < M - 1; i++) {
            if (strArr[i] == 'O' && strArr[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= N && strArr[i - (2 * N) + 1] == 'I') {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
