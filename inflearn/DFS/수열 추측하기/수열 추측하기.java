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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, F;
    static int[] combination;
    static int[][] dp;
    static boolean[] visited;
    static boolean check = false;
    static String answer = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        combination = new int[N];
        visited = new boolean[N + 1];
        dp = new int[N][N];
        for (int r = 0; r < N; r++) {
            combination[r] = makeCombination(N - 1, r);
        }

        DFS(0, 0, new int[N]);

        System.out.println(answer);
    }

    private static int makeCombination(int n, int r) {
        if (n == r || r == 0) return 1;
        if (dp[n][r] > 0) return dp[n][r];
        return dp[n][r] = makeCombination(n - 1, r - 1) + makeCombination((n - 1), r);
    }

    private static void DFS(int L, int sum, int[] arr) {
        if (sum > F || check) return;

        if (L == N) {
            if (sum == F) {
                for (int x : arr) {
                    answer += x + " ";
                }
                check = true;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[L] = i;
                DFS(L + 1, sum + (i * combination[L]), arr);
                visited[i] = false;
            }
        }
    }
}
