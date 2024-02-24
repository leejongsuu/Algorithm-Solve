import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] digit = {1, 2, 3};
    static int N;
    static int cnt;

    static void DFS(int sum) {
        if (sum > N) return;

        if (sum == N) {
            cnt++;
        } else {
            for (int i = 0; i < digit.length; i++) {
                DFS(sum + digit[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            DFS(0);
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}