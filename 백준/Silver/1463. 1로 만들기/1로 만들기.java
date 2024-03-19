import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dfs(N, 0));
    }

    static int dfs(int n, int cnt) {
        if (n < 2) {
            return cnt;
        }
        return Math.min(dfs(n / 3, cnt + 1 + n % 3), dfs(n / 2, cnt + 1 + n % 2));
    }
}
