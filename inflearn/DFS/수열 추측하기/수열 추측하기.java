//예시 입력 4 16
//예시 출력 3 1 2 4

import java.util.Scanner;

public class Main {
    static int n, t;
    static int[] c, p, ch;
    static int[][] di;
    static boolean flag = false;

    public int combi(int n, int r) {
        if(di[n][r]>0) return di[n][r];
        if(n==r || r==0) return 1;
        else return di[n][r]=combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if(L==n && sum==t){
            for(int x : p)
                System.out.print(x + " ");
            flag = true;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if(ch[i]==0){
                    ch[i]=1;
                    p[L]=i;
                    DFS(L+1,sum+(p[L]*c[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        c = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        di = new int[n][n];
        for (int i = 0; i < n; i++) {
            c[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);
    }
}
