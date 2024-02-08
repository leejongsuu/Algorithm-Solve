import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static int lowerBound(int key) {

        int lo = 0;
        int hi = arr.length;
        int mid;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            mid = (lo + hi) / 2; //중간 위치를 구함

            /**
             * key 값이 중간 위치의 값보다 작거나 같을 경우
             * (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내림.)
             */
            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int upperBound(int key) {

        int lo = 0;
        int hi = arr.length;
        int mid;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            mid = (lo + hi) / 2; //중간 위치를 구함

            //key 값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid;
            }
            //중복원소의 경우 else에서 처리됨
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] nInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nInput[i]);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        String[] mInput = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            sb.append(upperBound(Integer.parseInt(mInput[i])) - lowerBound(Integer.parseInt(mInput[i]))).append(' ');
        }

        System.out.println(sb);
    }
}