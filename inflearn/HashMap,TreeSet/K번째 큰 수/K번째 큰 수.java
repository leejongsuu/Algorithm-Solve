// 예시 입력
/*
10 3
13 15 34 23 45 65 33 11 26 42
*/

// 예시 출력 143

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {


    public int solution(int n, int m, int[] arr) {

        int answer = -1;
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    tree.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        int cnt = 1;
        for (int x : tree) {
            if(cnt==m) return x;
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(T.solution(n, m, arr));
    }
}
