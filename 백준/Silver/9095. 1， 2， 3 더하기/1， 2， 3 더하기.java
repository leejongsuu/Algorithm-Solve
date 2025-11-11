import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;
    final static int[] num = {1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            count = 0;
            dfs(n, 0);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int n, int sum) {
        if (sum >= n) {
            if (sum == n) count++;
            return;
        }

        for (int i = 0; i < num.length; i++) {
            dfs(n, sum + num[i]);
        }
    }
}
