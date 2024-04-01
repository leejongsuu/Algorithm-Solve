import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int Red = 0;
    static final int Green = 1;
    static final int Blue = 2;

    static int[][] house, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        house = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            house[i][Red] = Integer.parseInt(st.nextToken());
            house[i][Green] = Integer.parseInt(st.nextToken());
            house[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = house[0][Red];
        dp[0][Green] = house[0][Green];
        dp[0][Blue] = house[0][Blue];

        System.out.println(Math.min(DFS(n - 1, Red), Math.min(DFS(n - 1, Green), DFS(n - 1, Blue))));
    }

    static int DFS(int n, int color) {

        if (dp[n][color] != 0) {
            return dp[n][color];
        }

        if (color == Red) {
            return dp[n][Red] = Math.min(DFS(n - 1, Green), DFS(n - 1, Blue)) + house[n][Red];
        } else if (color == Green) {
            return dp[n][Green] = Math.min(DFS(n - 1, Red), DFS(n - 1, Blue)) + house[n][Green];
        } else if (color == Blue) {
            return dp[n][Blue] = Math.min(DFS(n - 1, Red), DFS(n - 1, Green)) + house[n][Blue];
        }

        return dp[n][color];
    }
}