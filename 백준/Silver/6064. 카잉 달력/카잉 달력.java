import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);
            sb.append(solution(M, N, x, y)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(int m, int n, int x, int y) {

        x -= 1;
        y -= 1;

        for (int i = x; i < (n * m); i += m) {
            if (i % n == y) {
                return i + 1;
            }
        }

        return -1;
    }
}
