import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] sequence = new int[N]; // 수열 저장 배열
        int[] l_dp = new int[N]; // 증가 부분 수열의 길이 저장 배열
        int[] r_dp = new int[N]; // 감소 부분 수열의 길이 저장 배열

        // 수열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 부분 수열의 길이 계산
        l_dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] > sequence[j] && l_dp[j] > max) {
                    max = l_dp[j];
                }
            }
            l_dp[i] = max + 1;
        }

        // 감소 부분 수열의 길이 계산
        r_dp[N - 1] = 1;
        for (int i = N - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if (sequence[i] > sequence[j] && r_dp[j] > max) {
                    max = r_dp[j];
                }
            }
            r_dp[i] = max + 1;
        }

        // 증가 부분 수열과 감소 부분 수열의 합으로 최대 바이토닉 수열의 길이 계산
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int length = l_dp[i] + r_dp[i] - 1; // 중복된 요소를 하나 제거
            if (length > maxLength) {
                maxLength = length;
            }
        }

        // 결과 출력
        System.out.println(maxLength);
    }
}
