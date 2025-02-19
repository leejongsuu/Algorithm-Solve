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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][R + 1];

        System.out.println(DFS(N, R));
    }

    private static int DFS(int n, int r) {
        if (r == 0 || n == r) return 1;
        if (dp[n][r] > 0) return dp[n][r];

        return dp[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}
