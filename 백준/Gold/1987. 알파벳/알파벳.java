import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, answer = Integer.MIN_VALUE;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }
//        board = new char[R + 2][C + 2];
//        for (int i = 1; i <= R; i++) {
//            String input = br.readLine();
//            for (int j = 1; j <= C; j++) {
//                board[i][j] = input.charAt(j - 1);
//            }
//        }
//
//        for (int i = 0; i < C + 2; i++) board[0][i] = board[R + 1][i] = board[1][1];
//        for (int i = 0; i < R + 2; i++) board[i][0] = board[i][R + 1] = board[1][1];

        visited = new boolean[26];
        visited[board[0][0] - 'A'] = true;
        DFS(1, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int L, int y, int x) {
        if (L > answer) answer = L;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[board[ny][nx] - 'A']) {
                visited[board[ny][nx] - 'A'] = true;
                DFS(L + 1, ny, nx);
                visited[board[ny][nx] - 'A'] = false;
            }
        }
    }
}
