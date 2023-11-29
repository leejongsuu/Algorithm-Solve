// 예시 입력
/*
8
20 25 52 30 39 33 43 33
*/

//예시 출력 D

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public char solution(int n, int[] arr){

        char answer = 'U';
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++)
            if(arr[i]==arr[i+1]) return 'D';
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n,arr));
    }
}
