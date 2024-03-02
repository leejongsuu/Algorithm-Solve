import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(BFS(0, 0));
    }

    private static int BFS(int y, int x) {

        int[][] distance = new int[N][M];

        board[y][x] = 0;
        distance[y][x] = 1;

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(y, x));

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && board[ny][nx] == 1) {

                    distance[ny][nx] = distance[now.y][now.x] + 1;

                    if (ny == N - 1 && nx == M - 1) {
                        return distance[ny][nx];
                    }

                    board[ny][nx] = 0;
                    Q.offer(new Point(ny, nx));
                }
            }
        }

        return distance[N - 1][M - 1];
    }
}
