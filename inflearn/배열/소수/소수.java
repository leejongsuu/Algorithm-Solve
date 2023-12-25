// 예시 입력 20
// 예시 출력 8

import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int answer = 0;

        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if(arr[i]==0) answer++;
            for (int j = 2; i * j <= n; j++) arr[i * j] = 1;
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
