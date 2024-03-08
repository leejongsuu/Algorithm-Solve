import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int z, y, x;

    public Point(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int M, N, H, sum;
    static int[][][] box;
    static Queue<Point> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        sum = M * N * H;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        Q.offer(new Point(i, j, k));
                        sum--;
                    } else if (box[i][j][k] == -1) {
                        sum--;
                    }
                }
            }
        }

        if (sum == 0) {
            System.out.println(0);
        } else {
            System.out.println(BFS());
        }
    }

    private static int BFS() {

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Point now = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];
                    if (ny >= 0 && nx >= 0 && ny < N && nx < M && box[now.z][ny][nx] == 0) {
                        box[now.z][ny][nx] = 1;
                        Q.offer(new Point(now.z, ny, nx));
                        sum--;
                    }
                }

                if (now.z + 1 < H && box[now.z + 1][now.y][now.x] == 0) {
                    box[now.z + 1][now.y][now.x] = 1;
                    Q.offer(new Point(now.z + 1, now.y, now.x));
                    sum--;
                }

                if (now.z - 1 >= 0 && box[now.z - 1][now.y][now.x] == 0) {
                    box[now.z - 1][now.y][now.x] = 1;
                    Q.offer(new Point(now.z - 1, now.y, now.x));
                    sum--;
                }

            }
            level++;

            if (sum == 0) return level;
        }

        return sum > 0 ? -1 : level;
    }
}

