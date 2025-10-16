import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 2][N + 2];
        for (int i = 0; i <= N; i++) {
            board[i][0] = -1;
            board[0][i] = -1;
            board[i][N + 1] = -1;
            board[N + 1][i] = -1;
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        Direction[] changeDirs = new Direction[L];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            changeDirs[i] = new Direction(t, d);
        }

        final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        board[1][1] = 1;
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{1, 1});

        int d = 0, i = 0;
        int time = 0;
        while (true) {
            time++;

            int nr = snake.peekFirst()[0] + dir[d][0];
            int nc = snake.peekFirst()[1] + dir[d][1];

            if (board[nr][nc] == -1 || board[nr][nc] == 1) {
                System.out.println(time);
                return;
            }

            if (board[nr][nc] == 0) {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            snake.addFirst(new int[]{nr, nc});
            board[nr][nc] = 1;

            if (i < L && time == changeDirs[i].t) {
                if (changeDirs[i].d == 'D') {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
                i++;
            }
        }
    }

    static class Direction {
        int t;
        char d;

        Direction(int t, char d) {
            this.t = t;
            this.d = d;
        }
    }
}