//예시 입력 5 3
//예시 출력 10

import java.util.Scanner;

public class Main {

    static int n, r;
    static int[][] dis;

    public int DFS(int n, int r) {
        if(dis[n][r]>0) return dis[n][r];

        if(n==r || r==0) return 1;
        else return dis[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        dis = new int[n+1][r+1];

        System.out.println(T.DFS(n, r));
    }
}
