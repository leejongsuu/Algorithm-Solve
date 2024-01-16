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
