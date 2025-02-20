//예시 입력 
/*
5 20
10 5
25 12
15 8
6 3
7 4
*/

//예시 출력 41

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] score, time, dy;

    public int solution() {

        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m; j>=time[i]; j--) {
                dy[j] = Math.max(dy[j], dy[j - time[i]] + score[i]);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        score = new int[n];
        time = new int[n];
        dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        System.out.println(T.solution());
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Question implements Comparable<Question> {
        int score, time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Question o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Question[] questions = new Question[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            questions[i] = new Question(score, time);
        }

        Arrays.sort(questions);

        int[] dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
            int time = questions[i].time;
            for (int j = M; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + questions[i].score);
            }
        }

        System.out.println(dp[M]);
    }
}
