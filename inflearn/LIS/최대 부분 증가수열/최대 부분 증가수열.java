//예시 입력
/*
8
5 3 7 8 6 2 9 4
*/

//예시 출력 4

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] dy;

    public int solution(int n) {
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i]>arr[j] && dy[j]>max) max = dy[j];
            }
            dy[i] = max + 1;
        }
        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println(T.solution(n));
    }
}
