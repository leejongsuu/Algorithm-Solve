// 예시 입력
/*
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
*/

// 예시 출력 10

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int p = arr[i][j];
                if(p>arr[i-1][j] && p>arr[i+1][j] && p>arr[i][j-1] && p>arr[i][j+1]) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
