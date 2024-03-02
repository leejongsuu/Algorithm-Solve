import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    total++;
                    list.add(BFS(i, j));
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        sb.append(total).append('\n');
        for (Integer i : list) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    private static int BFS(int y, int x) {

        board[y][x] = 0;

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(y, x));

        int cnt = 1;
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < N && board[ny][nx] == 1) {
                    cnt++;
                    board[ny][nx] = 0;
                    Q.offer(new Point(ny, nx));
                }
            }
        }

        return cnt;
    }
}
