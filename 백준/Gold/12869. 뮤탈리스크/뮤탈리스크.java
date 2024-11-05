import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min;
    static int[][][] dp;
    static int[][] damage = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        min = Integer.MAX_VALUE;
        dp = new int[61][61][61];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] scv = new int[3];
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, scv);

        System.out.println(min);
    }

    private static void DFS(int cnt, int[] scv) {

        if (cnt >= min) return;

        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= cnt) {
            return;
        }

        dp[s1][s2][s3] = cnt;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 6; i++) {
            scv = new int[]{Math.max(s1 - damage[i][0], 0), Math.max(s2 - damage[i][1], 0), Math.max(s3 - damage[i][2], 0)};
            DFS(cnt + 1, scv);
        }
    }
}