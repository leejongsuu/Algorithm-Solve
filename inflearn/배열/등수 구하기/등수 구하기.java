//예시 입력  5    87 89 92 100 76
//예시 출력 4 3 2 1 5


import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public int[] solution(int n, int[] arr) {

        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) if(arr[j]>arr[i]) answer[i]++;
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for(int x : T.solution(n,arr)) System.out.print(x + " ");
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int score : scores) {
            int rank = 1;
            for (int temp : scores) {
                if (temp > score) rank++;
            }
            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
}
