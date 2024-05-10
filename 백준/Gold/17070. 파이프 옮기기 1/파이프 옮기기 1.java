import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, count = 0;
    static int[][] board;

    static final int width = 0;
    static final int length = 1;
    static final int diagonal = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            board[0][i] = board[N + 1][i] = board[i][0] = board[i][N + 1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1, 2, width);
        System.out.println(count);
    }

    private static void DFS(int y, int x, int before) {
        if (y == N && x == N) count++;
        else {
            if (before == width && board[y][x + 1] == 0) {
                DFS(y, x + 1, width);
            } else if (before == length && board[y + 1][x] == 0) {
                DFS(y + 1, x, length);
            } else if (before == diagonal) {
                if (board[y][x + 1] == 0) {
                    DFS(y, x + 1, width);
                }
                if (board[y + 1][x] == 0) {
                    DFS(y + 1, x, length);
                }
            }
            if (board[y][x + 1] == 0 && board[y + 1][x + 1] == 0 && board[y + 1][x] == 0) {
                DFS(y + 1, x + 1, diagonal);
            }
        }
    }
}
