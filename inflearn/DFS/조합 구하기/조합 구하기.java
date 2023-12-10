//예시 입력 4 2
//예시 출력
/*
1 2
1 3
1 4
2 3
2 4
3 4
*/

import java.util.Scanner;

public class Main {

    static int n, r;
    static int[] p;
    public void DFS(int L, int S) {
        if (L == r) {
            for(int x : p){
                System.out.print(x + " ");
            }
            System.out.println();
        } else{
            for (int i = S; i <= n; i++) {
                p[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        p = new int[r];
        T.DFS(0,1);
    }
}
