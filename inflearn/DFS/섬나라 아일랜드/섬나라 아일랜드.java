//예시 입력
/*
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
*/

//예시 출력 5

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int[] dx = {0, -1, 0, 1, -1, 1, 1, -1};
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[][] maze;

    public void DFS(int x, int y) {

        maze[x][y] = 0;
        for (int j = 0; j < 8; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && maze[nx][ny] == 1)
                DFS(nx, ny);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        n = sc.nextInt();
        maze = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) maze[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (maze[i][j] == 1) {
                    T.DFS(i, j);
                    answer++;
                }

        System.out.println(answer);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int r, int c) {

        board[r][c] = 0;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && board[nr][nc] == 1) {
                DFS(nr, nc);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
