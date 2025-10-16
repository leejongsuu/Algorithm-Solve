import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result = 0;
    static int[][] board;
    static List<int[]> virus = new ArrayList<>();

    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, new int[3]);

        System.out.println(result);
    }

    public static void dfs(int L, int start, int[] arr) {
        if (L == 3) {
            int count = solution(arr);
            result = Math.max(result, count);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;
            if (board[r][c] == 0) {
                arr[L] = i;
                dfs(L + 1, i + 1, arr);
            }
        }
    }

    public static int solution(int[] arr) {

        int count = 0;

        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(board[i], M);
        }

        for (int i : arr) {
            int r = i / M;
            int c = i % M;
            temp[r][c] = 1;
        }

        for (int[] v : virus) {
            spread(v[0], v[1], temp);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    count++;
                }
            }
        }


        return count;
    }

    public static void spread(int r, int c, int[][] temp) {
        temp[r][c] = 2;
        for (int d = 0; d < 4; d++) {
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && temp[nr][nc] == 0) {
                spread(nr, nc, temp);
            }
        }
    }
}