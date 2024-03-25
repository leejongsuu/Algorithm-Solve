import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(solution(M, N, x, y)).append('\n');
        }

        System.out.println(sb);
    }

    static int solution(int m, int n, int x, int y) {

        x -= 1;
        y -= 1;

        for (int i = x; i < (m * n); i += m) {
            if (i % n == y) {
                return i + 1;
            }
        }

        return -1;
    }
}