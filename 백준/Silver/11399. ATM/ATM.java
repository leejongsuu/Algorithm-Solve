import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(input[i]);
        }

        // 오름차순으로 정렬
        Arrays.sort(times);

        int totalTime = 0; // 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하기 위한 변수
        int cumulativeTime = 0; // 다음 사람의 인출 시작 시간을 위한 누적 시간 변수

        for (int i = 0; i < N; i++) {
            cumulativeTime += times[i];
            totalTime += cumulativeTime; // 각 사람의 누적 시간을 더하여 총 시간에 추가
        }

        System.out.println(totalTime);
    }
}
