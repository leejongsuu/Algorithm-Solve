import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, s, w;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static char[][] area;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        area = new char[n][m];
        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                area[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s = 0;
                w = 0;
                if (area[i][j] == 'o') {
                    s++;
                    DFS(i, j);
                } else if (area[i][j] == 'v') {
                    w++;
                    DFS(i, j);
                }

                if (s > w) sheep += s;
                else wolf += w;
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void DFS(int y, int x) {

        area[y][x] = '#';

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isIn(ny, nx) && area[ny][nx] != '#') {
                if (area[ny][nx] == 'o') s++;
                else if (area[ny][nx] == 'v') w++;
                DFS(ny, nx);
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}