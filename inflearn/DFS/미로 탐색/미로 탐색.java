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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze = new int[7][7];
    static int answer = 0;

    public void DFS(int x, int y) {
       if(x==6&&y==6) answer++;
       else{
           for(int i=0; i<4; i++){
               int nx = x + dx[i];
               int ny = y + dy[i];
               if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && maze[nx][ny] == 0) {
                   maze[nx][ny] = 1;
                   DFS(nx, ny);
                   maze[nx][ny] = 0;
               }
           }
       }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        maze[0][0]=1;
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
