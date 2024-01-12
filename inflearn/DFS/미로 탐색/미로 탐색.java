//예시 출력
/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
*/
//예시 출력 8

import java.util.Scanner;

public class Main {

    static int n, answer = 0;
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    static int[][] board;

    public void DFS(int x, int y) {

        if (x == n-1 && y == n-1) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[x][y] = 1;
                    DFS(nx, ny);
                    board[x][y] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) board[i][j] = sc.nextInt();

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
