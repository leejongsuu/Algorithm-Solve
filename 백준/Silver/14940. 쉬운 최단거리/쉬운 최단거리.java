import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int N, M;
    static int[][] di, graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        di = new int[N][M];

        int y = 0, x = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    di[i][j] = 0;
                    y = i;
                    x = j;
                } else if (graph[i][j] == 0) {
                    di[i][j] = 0;
                } else {
                    di[i][j] = -1;
                }
            }
        }


        solution(y, x);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(di[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void solution(int y, int x) {

        int[][] ch = new int[N][M];
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        di[y][x] = 0;

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(y, x));

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && graph[ny][nx] == 1 && ch[ny][nx] == 0) {
                    di[ny][nx] = di[now.y][now.x] + 1;
                    ch[ny][nx] = 1;
                    Q.offer(new Point(ny, nx));
                }
            }
        }
    }
}
