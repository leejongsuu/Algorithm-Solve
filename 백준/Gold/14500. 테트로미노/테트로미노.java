import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = Integer.MIN_VALUE;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int L, int sum) {

        if (L == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx]) {

                if (L == 2) {
                    visited[ny][nx] = true;
                    dfs(y, x, L + 1, sum + board[ny][nx]);
                    visited[ny][nx] = false;
                }

                visited[ny][nx] = true;
                dfs(ny, nx, L + 1, sum + board[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }
}

