import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] color, abColor;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        color = new char[N][N];
        abColor = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                color[i][j] = abColor[i][j] = c;
                if (abColor[i][j] == 'G') {
                    abColor[i][j] = 'R';
                }
            }
        }

        int cnt = 0, abCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (color[i][j] != '0') {
                    cnt++;
                    dfs(i, j, color[i][j]);
                }

                if (abColor[i][j] != '0') {
                    abCnt++;
                    dfs2(i, j, abColor[i][j]);
                }
            }
        }
        System.out.println(cnt + " " + abCnt);
    }

    static void dfs(int y, int x, char cur) {
        color[y][x] = '0';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < N && color[ny][nx] == cur) {
                color[ny][nx] = '0';
                dfs(ny, nx, cur);
            }
        }
    }

    static void dfs2(int y, int x, char cur) {
        abColor[y][x] = '0';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < N && abColor[ny][nx] == cur) {
                abColor[ny][nx] = '0';
                dfs2(ny, nx, cur);
            }
        }
    }
}

