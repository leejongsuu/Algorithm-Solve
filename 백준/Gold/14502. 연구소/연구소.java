import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, maxSafeArea;
    static int[][] board;
    static ArrayList<Point> virusList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        maxSafeArea = 0;
        DFS(0);
        System.out.println(maxSafeArea);
    }

    private static void DFS(int L) {

        if (L == 3) {
            int safeArea = BFS();
            maxSafeArea = Math.max(maxSafeArea, safeArea);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    DFS(L + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static int BFS() {

        int[][] tempBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, tempBoard[i], 0, M);
        }

        Queue<Point> queue = new LinkedList<>();
        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{0, 1, 0, -1};
        for (Point p : virusList) {
            queue.offer(p);
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M && tempBoard[ny][nx] == 0) {
                    tempBoard[ny][nx] = 2;
                    queue.add(new Point(ny, nx));
                }
            }
        }

        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempBoard[i][j] == 0) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }
}
