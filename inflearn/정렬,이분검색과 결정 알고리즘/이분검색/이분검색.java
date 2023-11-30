//예시 입력
/*
8 32
23 87 65 12 57 32 99 81
*/

//예시 출력 3

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);

        int lt = 0, rt = n-1;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (arr[mid] == m) return mid + 1;
            else if (arr[mid] > m) rt = mid -1;
            else lt = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n,m, arr));
    }
}
