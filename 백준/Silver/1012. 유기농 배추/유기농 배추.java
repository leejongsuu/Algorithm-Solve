import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int M, N;
    static int[][] place;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static void DFS(int y, int x) {

        place[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && place[ny][nx] == 1) {
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] info = br.readLine().split(" ");
            M = Integer.parseInt(info[0]);
            N = Integer.parseInt(info[1]);
            int K = Integer.parseInt(info[2]);

            place = new int[N][M];

            for (int j = 0; j < K; j++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                place[y][x] = 1;
            }

            int cnt = 0;
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < M; v++) {
                    if (place[u][v] == 1) {
                        cnt++;
                        DFS(u, v);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
