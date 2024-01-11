//예시 입력
/*
  3
1 2 5
  15
*/

//예시 출력 3

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int n, total, answer = Integer.MAX_VALUE;
    static Integer[] coin;

    public void DFS(int cnt, int sum) {

        if (sum > total || cnt >= answer) return;

        if (sum == total) answer = Math.min(answer, cnt);
        else {
            for (int i =0; i <n; i++) {
                DFS(cnt + 1, sum + coin[i]);
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coin = new Integer[n];
        for (int i = 0; i < n; i++) coin[i] = sc.nextInt();
        total = sc.nextInt();

        Arrays.sort(coin, Collections.reverseOrder());

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
