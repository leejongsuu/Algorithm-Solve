//예시 입력
/*
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
*/

//예시 출력 4

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int x, y, count=0;
    static int[][] box, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();

    public int BFS() {

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point p = Q.poll();
                for(int j=0; j<4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && nx < x && ny >= 0 && ny < y && box[ny][nx] == 0) {
                        Q.offer(new Point(nx, ny));
                        box[ny][nx] = 1;
                        count--;
                    }
                }
            }
            level++;
        }
        if(count ==0) return level - 1;
        else return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();
        box = new int[y][x];
        dis = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int data = sc.nextInt();
                if(data==1) Q.offer(new Point(j, i));
                else if(data==0) count++;
                box[i][j] = data;
            }
        }
        if(count==0) System.out.println(0);
        else System.out.println(T.BFS());
    }
}
