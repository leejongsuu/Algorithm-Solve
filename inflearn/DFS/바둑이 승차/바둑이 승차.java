//예시 입력
/*
259 5
81
58
42
33
61
*/

//예시 출력 242
import java.util.Scanner;

public class Main {

    static int total, n, max = 0;
    static int[] arr;

    public void DFS(int L, int sum) {
        if (sum>total) return;

        if (L==n) max = Math.max(max, sum);
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        total = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        T.DFS(0,0);
        System.out.println(max);
    }
}
