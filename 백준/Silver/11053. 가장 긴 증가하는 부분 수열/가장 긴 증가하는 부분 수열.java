import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }

    static int solution(int[] arr) {

        int[] lis = new int[arr.length];
        int len = 0; //LIS의 길이

        for (int num : arr) {
            int index = Arrays.binarySearch(lis, 0, len, num);

            // binarySearch 반환 값이 음수일 때는 적절한 위치를 찾지 못한 경우
            if (index < 0) {
                index = -(index + 1);
            }

            // LIS를 갱신
            lis[index] = num;

            // 현재 원소가 LIS의 끝에 추가될 경우 길이 증가
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
