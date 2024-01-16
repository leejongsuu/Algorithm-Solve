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

    public void BFS(int x, int y) {

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        while (!Q.isEmpty()) {
            Point p = Q.poll();
            maze[p.x][p.y] = 0;
            for (int j = 0; j < 8; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && maze[nx][ny] == 1)
                    Q.offer(new Point(nx, ny));
            }
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
                    T.BFS(i, j);
                    answer++;
                }

        System.out.println(answer);

    }
}
