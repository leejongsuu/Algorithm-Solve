//예시 입력
/*
5
1 3 9 5 2
5
3 2 5 7 8
*/

//예시 출력 2 3 5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public ArrayList<Integer> solution(int[] a, int[] b) {

        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a); Arrays.sort(b);

        int lt = 0, rt = 0;
        while (lt < a.length && rt < b.length) {
            if(a[lt]<b[rt]) lt++;
            else if(a[lt]>b[rt]) rt++;
            else {
                answer.add(a[lt]);
                lt++;
                rt++;
            }
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        for(int x : T.solution(a,b)) System.out.print(x + " ");
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
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        StringBuilder sb = new StringBuilder();

        int lt = 0;
        int rt = 0;
        while (lt < N && rt < M) {
            if (arr1[lt] == arr2[rt]) {
                sb.append(arr1[lt]).append(' ');
                lt++;
                rt++;
            } else if (arr1[lt] < arr2[rt]) {
                lt++;
            } else {
                rt++;
            }
        }

        System.out.println(sb);
    }
}

