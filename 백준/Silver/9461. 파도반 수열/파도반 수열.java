import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr = new long[101];

    static long solution(int n) {
        if (n <= 3) return 1;
        if (arr[n] != 0) return arr[n];
        else {
            return arr[n] = solution(n - 3) + solution(n - 2);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(solution(Integer.parseInt(br.readLine()))).append('\n');
        }

        System.out.println(sb);
    }
}