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
    static int n, total;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum){
        if(sum>total) return;
        if(L>=answer) return;
        if(sum==total){
            answer = Math.min(answer, L);
        }
        else {
            for(int i=0; i<n; i++){
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        total = sc.nextInt();
        T.DFS(0,0);
        System.out.println(answer);
    }
}
