import java.util.Scanner;

public class Main {

    public int[] solution(int n) {

        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) answer[i] = answer[i - 1] + answer[i - 2];

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int x : T.solution(n)) {
            System.out.print(x+" ");
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        StringBuilder sb = new StringBuilder("1 1 ");
        dp[0] = dp[1] = 1;
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            sb.append(dp[i]).append(' ');
        }

        System.out.println(sb);
    }
}
