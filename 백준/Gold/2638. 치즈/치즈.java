import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[][] paper;
    static int[][] airCheese;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        while (true) {
            airCheese = new int[N][M];
            visited = new boolean[N][M];

            DFS(0, 0);
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (airCheese[i][j] >= 2) {
                        paper[i][j] = 0;
                        flag = false;
                    }
                }
            }

            if (flag) {
                System.out.println(hour);
                break;
            }
            hour++;
        }
    }

    private static void DFS(int y, int x) {

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isIn(ny, nx) && !visited[ny][nx]) {
                if (paper[ny][nx] == 1) {
                    airCheese[ny][nx]++;
                } else {
                    DFS(ny, nx);
                }
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}