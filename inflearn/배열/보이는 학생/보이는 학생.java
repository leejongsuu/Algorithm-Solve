import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public int solution(int n, int[] arr){

        int answer = 1;
        int max = arr[0];
        for (int x : arr) {
            if (x > max) {
                answer++;
                max=x;
            }
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(T.solution(n, arr));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int max = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num > max) {
                answer++;
                max = num;
            }
        }

        System.out.println(answer);
    }
}
