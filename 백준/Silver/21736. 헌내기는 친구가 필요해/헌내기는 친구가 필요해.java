import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M, cnt = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] campus;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        campus = new char[N][M];
        int px = 0, py = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    py = i;
                    px = j;
                }
            }
        }

        DFS(py, px);

        if (cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }

    static void DFS(int y, int x) {

        if (campus[y][x] == 'P') {
            cnt++;
        }

        campus[y][x] = 'X';

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < M && campus[ny][nx] != 'X') {
                DFS(ny, nx);
            }
        }
    }
}