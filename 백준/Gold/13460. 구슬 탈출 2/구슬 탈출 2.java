import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int[] bead = new int[4];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'R') {
                    bead[0] = i;
                    bead[1] = j;
                }
                if (board[i][j] == 'B') {
                    bead[2] = i;
                    bead[3] = j;
                }
            }
        }

        int result = BFS(bead);
        System.out.println(result);
    }

    private static int BFS(int[] bead) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(bead);

        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[bead[0]][bead[1]][bead[2]][bead[3]] = true;

        int cnt = 0;
        while (cnt < 10) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int redRow = current[0];
                int redCol = current[1];
                int blueRow = current[2];
                int blueCol = current[3];

                for (int j = 0; j < 4; j++) {
                    int[] nextRed = untilMoveWallOrHole(redRow, redCol, j);
                    int nextRedRow = nextRed[0];
                    int nextRedCol = nextRed[1];
                    int redMoveCount = nextRed[2];

                    int[] nextBlue = untilMoveWallOrHole(blueRow, blueCol, j);
                    int nextBlueRow = nextBlue[0];
                    int nextBlueCol = nextBlue[1];
                    int blueMoveCount = nextBlue[2];

                    if (board[nextBlueRow][nextBlueCol] == 'O') {
                        continue;
                    }

                    if (board[nextRedRow][nextRedCol] == 'O') {
                        return cnt;
                    }

                    if (nextRedRow == nextBlueRow && nextBlueCol == nextRedCol) {
                        if (redMoveCount > blueMoveCount) {
                            nextRedRow -= dr[j];
                            nextRedCol -= dc[j];
                        } else {
                            nextBlueRow -= dr[j];
                            nextBlueCol -= dc[j];
                        }
                    }

                    if (!visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol]) {
                        visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol] = true;
                        queue.offer(new int[]{nextRedRow, nextRedCol, nextBlueRow, nextBlueCol});
                    }
                }
            }
        }

        return -1;
    }

    private static int[] untilMoveWallOrHole(int r, int c, int d) {
        int moveCount = 0;
        while (board[r + dr[d]][c + dc[d]] != '#' && board[r][c] != 'O') {
            r += dr[d];
            c += dc[d];
            moveCount++;
        }
        return new int[]{r, c, moveCount};
    }
}
