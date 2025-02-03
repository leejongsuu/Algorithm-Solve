import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        int[] bead = new int[4]; // [0] : redRow, [1] : redCol, [2] : blueRow, [3] : blueCol

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
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
                    int[] movedRed = moveUntilWallOrHole(redRow, redCol, j);
                    int nextRedRow = movedRed[0];
                    int nextRedCol = movedRed[1];
                    int redMoveCount = movedRed[2];

                    int[] moveBlue = moveUntilWallOrHole(blueRow, blueCol, j);
                    int nextBlueRow = moveBlue[0];
                    int nextBlueCol = moveBlue[1];
                    int blueMoveCount = moveBlue[2];

                    if (board[nextBlueRow][nextBlueCol] == 'O') {
                        continue;
                    }

                    if (board[nextRedRow][nextRedCol] == 'O') {
                        return cnt;
                    }

                    if (nextRedRow == nextBlueRow && nextRedCol == nextBlueCol) {
                        if (redMoveCount > blueMoveCount) {
                            nextRedRow -= dy[j];
                            nextRedCol -= dx[j];
                        } else {
                            nextBlueRow -= dy[j];
                            nextBlueCol -= dx[j];
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

    private static int[] moveUntilWallOrHole(int y, int x, int d) {
        int moveCount = 0; // Red와 Blue가 누가 먼저 앞으로 쌓이는지 알기 위한 변수

        while (board[y + dy[d]][x + dx[d]] != '#' && board[y][x] != 'O') {
            y += dy[d];
            x += dx[d];
            moveCount++;
        }

        return new int[]{y, x, moveCount};
    }
}
