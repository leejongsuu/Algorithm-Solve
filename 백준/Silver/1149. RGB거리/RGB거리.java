import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] Cost, DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Cost = new int[N][3];
        DP = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Cost[i][Red] = Integer.parseInt(st.nextToken());
            Cost[i][Green] = Integer.parseInt(st.nextToken());
            Cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        DP[0][Red] = Cost[0][Red];
        DP[0][Green] = Cost[0][Green];
        DP[0][Blue] = Cost[0][Blue];

        System.out.println(Math.min(DFS(N - 1, Red), Math.min(DFS(N - 1, Green), DFS(N - 1, Blue))));
    }

    static int DFS(int n, int color) {

        // 만약 탐색하지 않은 배열이라면
        if (DP[n][color] == 0) {


            // color의 색에 따라 이전 집의 서로 다른 색을 재귀 호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다.
            if (color == Red) {
                DP[n][color] = Math.min(DFS(n - 1, Green), DFS(n - 1, Blue)) + Cost[n][color];
            } else if (color == Green) {
                DP[n][color] = Math.min(DFS(n - 1, Red), DFS(n - 1, Blue)) + Cost[n][color];
            } else if (color == Blue) {
                DP[n][color] = Math.min(DFS(n - 1, Red), DFS(n - 1, Green)) + Cost[n][color];
            }
        }

        return DP[n][color];
    }
}