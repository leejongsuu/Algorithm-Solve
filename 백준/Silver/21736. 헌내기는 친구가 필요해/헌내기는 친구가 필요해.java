import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result = 0;
    static char[][] campus;
    static boolean[][] visited;

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int r = 0;
        int c = 0;

        campus = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);
                if (campus[i][j] == 'I') {
                    r = i;
                    c = j;
                }
            }
        }

        visited = new boolean[N][M];

        dfs(r, c);

        System.out.println(result == 0 ? "TT" : result);

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        if (campus[r][c] == 'P') {
            result++;
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (isIn(nr, nc) && !visited[nr][nc] && campus[nr][nc] != 'X') {
                dfs(nr, nc);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}