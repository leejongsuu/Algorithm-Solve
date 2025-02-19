// 예시 입력
/*
9 3
1 2 3 4 5 6 7 8 9
*/

// 예시 출력 17

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int count(int mid, int[] arr) {

        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > mid) {
                sum = 0;
                cnt++;
            }
            sum += x;
        }
        return cnt;
    }

    public int solution(int m, int[] arr) {

        int answer = 0;

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid, arr) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch(arr, M);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int capacity) {
        int lt = 0;
        int rt = Arrays.stream(arr).sum();

        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) > capacity) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        
        return lt;
    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > capacity) {
                cnt++;
                sum = 0;
            }
            sum += arr[i];
        }

        return cnt;
    }
}
