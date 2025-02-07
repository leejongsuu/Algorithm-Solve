// 예시 입력 10     1 0 1 1 1 0 0 1 1 0
// 예시 출력 10

import java.util.Scanner;

public class Main {

    public int solution(int n, int[] arr) {

        int answer = 0;
        int pt = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                answer += pt;
                pt++;
            } else pt = 1;
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

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        int score = 1;

        while (st.hasMoreTokens()) {
            int answer = Integer.parseInt(st.nextToken());
            if (answer == 1) {
                result += score++;
            } else {
                score = 1;
            }
        }

        System.out.println(result);
    }
}
