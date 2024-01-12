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

    static int n, m;
    static int[] arr;

    public void DFS(int L, int j) {

        if(L==m){
            for(int x : arr) System.out.print(x+" ");
            System.out.println();
        }

        else {
            for (int i = j+1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1, i);
            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        T.DFS(0, 0);
    }
}
