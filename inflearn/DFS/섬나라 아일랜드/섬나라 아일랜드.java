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

import java.util.Scanner;

public class Main {

    static int n, answer = 0;
    static int[][] box;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    public void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && box[nx][ny] == 1) {
                box[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        box = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                box[i][j] = sc.nextInt();
            }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    box[i][j] = 0;
                    answer++;
                    T.DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
