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
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int m, n, cnt=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] box;
    static Queue<Point> Q = new LinkedList<>();

    public int BFS() {

        int level = 0;
        while (!Q.isEmpty()) {

            int len = Q.size();
            boolean check = false;

            for (int i = 0; i < len; i++) {
                Point p = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && box[ny][nx]==0){
                        check = true;
                        box[ny][nx] = 1;
                        Q.offer(new Point(nx, ny));
                        cnt--;
                    }
                }
            }
            if(check) level++;
        }
        
        if(cnt==0) return level;
        else return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        box = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++){
                int tomato = sc.nextInt();

                if(tomato==1) Q.offer(new Point(j, i));
                else if(tomato==0) cnt++;

                box[i][j] = tomato;
            }

        if(cnt==0) System.out.println(0);
        else System.out.println(T.BFS());
    }
}
        if(count==0) System.out.println(0);
        else System.out.println(T.BFS());
    }
}
