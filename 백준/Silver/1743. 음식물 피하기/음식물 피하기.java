import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] progs = new boolean[n][m];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            progs[y - 1][x - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (progs[i][j]) {
                    cnt = 1;
                    DFS(0, i, j, progs);
                    result = Math.max(result, cnt);
                }
            }
        }

        System.out.println(result);
    }

    private static void DFS(int size, int y, int x, boolean[][] progs) {
        progs[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isIn(ny, nx) && progs[ny][nx]) {
                cnt++;
                DFS(size + 1, ny, nx, progs);
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}