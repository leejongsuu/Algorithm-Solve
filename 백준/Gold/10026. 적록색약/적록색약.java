import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int cnt = 0, cnt2 = 0;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] board, board2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        board2 = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                board[i][j] = ch;
                if (ch == 'B') {
                    board2[i][j] = ch;
                } else {
                    board2[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '0') {
                    char color = board[i][j];
                    cnt++;
                    board[i][j] = '0';
                    dfs(i, j, color);
                }

                if (board2[i][j] != '0') {
                    char color = board2[i][j];
                    cnt2++;
                    board2[i][j] = '0';
                    dfs2(i, j, color);
                }
            }
        }

        System.out.println(cnt + " " + cnt2);
    }

    static void dfs(int y, int x, char color) {

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < N && nx < N && board[ny][nx] == color) {
                board[ny][nx] = '0';
                dfs(ny, nx, color);
            }
        }
    }

    static void dfs2(int y, int x, char color) {

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < N && nx < N && board2[ny][nx] == color) {
                board2[ny][nx] = '0';
                dfs2(ny, nx, color);
            }
        }
    }
}