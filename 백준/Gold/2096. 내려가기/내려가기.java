import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기 줄의 값 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for (int i = 0; i < 3; i++) {
            maxDp[i] = minDp[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 줄부터 처리
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] current = new int[3];
            int[] maxNext = new int[3];
            int[] minNext = new int[3];
            for (int j = 0; j < 3; j++) {
                current[j] = Integer.parseInt(st.nextToken());
            }

            // 첫 번째 칸 업데이트
            maxNext[0] = Math.max(maxDp[0], maxDp[1]) + current[0];
            minNext[0] = Math.min(minDp[0], minDp[1]) + current[0];

            // 두 번째 칸 업데이트
            maxNext[1] = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + current[1];
            minNext[1] = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + current[1];

            // 세 번째 칸 업데이트
            maxNext[2] = Math.max(maxDp[1], maxDp[2]) + current[2];
            minNext[2] = Math.min(minDp[1], minDp[2]) + current[2];

            // 다음 줄을 현재 줄로 업데이트
            maxDp = maxNext;
            minDp = minNext;
        }

        // 최종 결과 찾기
        int maxScore = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int minScore = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
        System.out.println(maxScore + " " + minScore);
    }
}
