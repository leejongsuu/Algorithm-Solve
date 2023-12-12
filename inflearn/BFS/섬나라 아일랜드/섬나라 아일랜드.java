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

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, answer=0;
    static int[][] box;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static Queue<Point> Q = new LinkedList<>();

    public void BFS(int x, int y) {
        Q.add(new Point(x, y));
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && box[nx][ny] == 1) {
                    box[nx][ny] = 0;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        box = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    box[i][j] = 0;
                    answer++;
                    T.BFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
