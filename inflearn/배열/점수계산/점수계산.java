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
