//예시 입력 4 16
//예시 출력 3 1 2 4

import java.util.Scanner;

public class Main {

    static int n, total;
    static int[] arr, c, ch;
    static int[][] dis;
    static Boolean check = false;

    public int combi(int n, int r) {

        if(dis[n][r]>0) return dis[n][r];

        if (n==r || r==0) return 1;
        else return dis[n][r] = combi(n - 1, r) + combi(n - 1, r - 1);
    }

    public void DFS(int L , int sum) {

        if (sum>total || check) return;

        if(sum==total && L==n){
            for (int x : arr) System.out.print(x + " ");
            check = true;
        }
        else {
            for (int i = 1; i <= n; i++)
                if(ch[i]==0){
                    ch[i] = 1;
                    arr[L] = i;
                    DFS(L + 1, sum + arr[L] * c[L]);
                    ch[i] = 0;
                }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        total = sc.nextInt();
        arr = new int[n];
        c = new int[n];
        ch = new int[n + 1];
        dis = new int[n][n];

        for (int i = 0; i < n; i++) c[i] = T.combi(n - 1, i);

        T.DFS(0, 0);
    }
}
