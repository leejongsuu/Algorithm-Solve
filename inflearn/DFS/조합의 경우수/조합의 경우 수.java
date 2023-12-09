//예시 입력 5 3
//예시 출력 10

import java.util.Scanner;

public class Main {
    static int n, r;
    int[][] di = new int[35][35];

    public int DFS(int n, int r) {
        if(di[n][r]>0) return di[n][r];
        if (r == 1) return n;
        else if (r == n) return 1;
        else return di[n][r]=DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
