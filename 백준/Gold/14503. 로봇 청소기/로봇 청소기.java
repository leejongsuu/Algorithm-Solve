import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(r, c, d, room);

        System.out.println(result);
    }

    private static int solution(int r, int c, int d, int[][] room) {

        int clean = 0;

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (true) {
            if (room[r][c] == 0) {
                clean++;
                room[r][c] = 2;
            }

            boolean isNotClean = true;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dy[d];
                int nc = c + dx[d];
                if (isIn(nr, nc) && room[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    isNotClean = false;
                    break;
                }
            }

            if (isNotClean) {
                int temp_d = (d + 2) % 4;
                int nr = r + dy[temp_d];
                int nc = c + dx[temp_d];

                if (isIn(nr, nc) && room[nr][nc] != 1) {
                    r = nr;
                    c = nc;
                } else {
                    break;
                }
            }
        }

        return clean;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}