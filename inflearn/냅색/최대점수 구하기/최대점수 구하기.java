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

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] score, time, dy;

    public int solution() {

        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >=time[i]; j--) {
                dy[j] = Math.max(dy[j], dy[j - time[i]] + score[i]);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        dy = new int[m + 1];
        System.out.println(T.solution());
    }
}
