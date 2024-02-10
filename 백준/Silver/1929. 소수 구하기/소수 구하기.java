import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        // 수정: 배열 크기 조정
        boolean[] isPrime = new boolean[N - M + 1];

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= N; i++) {
            int start = M / i * i;
            if (start < M)
                start += i;
            if (start == i)
                start += i;
            for (int j = start; j <= N; j += i) {
                isPrime[j - M] = true;
            }
        }

        // 수정: 출력 형식 맞추기
        for (int i = Math.max(2, M); i <= N; i++) {
            if (!isPrime[i - M])
                sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}