//예시 입력
/*
3
1 2 5
15
*/

//예시 출력 3

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] coin, dy;

    public int solution() {

        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) coin[i] = sc.nextInt();

        m = sc.nextInt();
        dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        System.out.println(T.solution());
    }
}
