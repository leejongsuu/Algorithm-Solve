import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int count = 0;
    static int[][] plain;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            plain = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                plain[y][x] = 1;
            }

            count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (plain[y][x] == 1) {
                        count++;
                        dfs(y, x);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int y, int x) {
        plain[y][x] = 0;

        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if (isIn(ny, nx) && plain[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    public static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
