// 예시 입력 
/*
9
120 125 152 130 135 135 143 127 160
*/

//예시 출력 3 8

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public void solution(int n, int[] arr){

        int[] origin = arr.clone();
        Arrays.sort(arr);
        for(int i = 0; i<n;i++)
            if(origin[i]!=arr[i]) System.out.print((i+1) +" ");
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        T.solution(n,arr);
    }
}
