import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, clean = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] room;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(r, c, d);

        System.out.println(clean);
    }

    private static void DFS(int y, int x, int d) {

        if (room[y][x] == 0) {
            room[y][x] = 2;
            clean++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (isIn(ny, nx) && room[ny][nx] == 0) {
                DFS(ny, nx, d);
                return;
            }
        }

        int back_dir = (d + 2) % 4;
        int ny = y + dy[back_dir];
        int nx = x + dx[back_dir];
        if (isIn(ny, nx) && room[ny][nx] != 1) {
            DFS(ny, nx, d);
        }

    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}