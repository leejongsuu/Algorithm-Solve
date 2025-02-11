// 예시 입력
/*
10 3
12 15 11 20 25 10 20 19 13 15
*/

// 예시 출력 56

import java.util.Scanner;

public class Main {


    public int solution(int n, int m, int[] arr) {

        int answer = 0;
        for (int i = 0; i < m; i++) answer += arr[i];

        int lt = 0, rt = m;
        int sum = answer;
        while (rt < n) {
            sum += arr[rt++] - arr[lt++];
            answer = Math.max(answer, sum);
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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer, sum, rt;
        answer = sum = rt = 0;

        for (; rt < K; rt++) {
            answer = sum += arr[rt];
        }

        for (int lt = 0; rt < N; lt++, rt++) {
            sum = sum + arr[rt] - arr[lt];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
