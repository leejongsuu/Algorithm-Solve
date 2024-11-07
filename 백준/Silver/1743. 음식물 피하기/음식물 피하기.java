import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, size;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] progs = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            progs[y - 1][x - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (progs[i][j]) {
                    size = 1;
                    DFS(i, j, progs);
                    result = Math.max(result, size);
                }
            }
        }

        System.out.println(result);
    }

    private static void DFS(int y, int x, boolean[][] progs) {
        progs[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isIn(ny, nx) && progs[ny][nx]) {
                size++;
                DFS(ny, nx, progs);
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}