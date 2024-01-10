//예시 입력
/*
5 20
10 5
25 12
15 8
6 3
7 4
*/

//예시 출력 41

import java.util.Scanner;

public class Main {

    static int n, total, max=0;
    static int[][] score;

    public void DFS(int L, int time, int sum){

        if(time>total) return;

        if(L==n) max = Math.max(sum, max);
        else {
            DFS(L + 1, time + score[L][1],sum+score[L][0]);
            DFS(L + 1, time, sum);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        total = sc.nextInt();
        score = new int[n][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++) score[i][j] = sc.nextInt();

        T.DFS(0, 0, 0);
        System.out.println(max);
    }
}
