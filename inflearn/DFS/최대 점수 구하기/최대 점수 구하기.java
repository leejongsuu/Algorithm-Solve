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
    static int[][] arr;

    public void DFS(int L, int time, int score){
        if(time>total) return;
        if(L==n) max = Math.max(score, max);
        else {
            DFS(L + 1, time + arr[L][1],score+arr[L][0]);
            DFS(L + 1, time, score);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        total = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        T.DFS(0, 0, 0);
        System.out.println(max);
    }
}
