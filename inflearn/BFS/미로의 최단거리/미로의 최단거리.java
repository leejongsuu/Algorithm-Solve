//예시 입력
/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
*/

//예시 출력 12

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
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] maze;

    public int BFS(int v) {

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(v, v));

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point p = Q.poll();
                maze[p.x][p.y] = 1;
                if (p.x == n - 1 && p.y == n - 1) return level;
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && maze[nx][ny] == 0)
                        Q.offer(new Point(nx, ny));
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        maze = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) maze[i][j] = sc.nextInt();

        System.out.println(T.BFS(0));

    }
}
