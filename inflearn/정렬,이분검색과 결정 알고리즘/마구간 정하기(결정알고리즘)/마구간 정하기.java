// 예시 입력
/*
5 3
1 2 8 4 9
*/

//예시 출력 3

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public int count(int mid, int[] arr) {

        int cnt = 1, ep = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[ep] >= mid) {
                ep = i;
                cnt++;
            }
        }
        return cnt;
    }

    public int solution(int m, int[] arr) {

        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[arr.length - 1] - arr[0];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid, arr) < m) {
                rt = mid - 1;
            } else{
                answer = mid;
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(T.solution(m, arr));
    }
}
