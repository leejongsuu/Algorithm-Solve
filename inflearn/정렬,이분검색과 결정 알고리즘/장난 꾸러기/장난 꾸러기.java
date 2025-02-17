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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] sorted = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (arr[i] != sorted[i]) {
                sb.append(i + 1).append(' ');
            }
        }

        System.out.println(sb);
    }
}
