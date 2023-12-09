//예시 입력 3 2
//예시 출력
/*
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
*/

import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] arr;
    public void DFS(int L){
        if(L==m) {
            for(int x : arr)
                System.out.print(x+" ");
            System.out.println();
        }else {
            for(int i=1; i<=n; i++){
                arr[L]=i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.DFS(0);
    }
}
