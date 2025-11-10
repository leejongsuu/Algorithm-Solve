import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        final int INF = 41;

        int[][] fibo = new int[INF][2];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] result = getfibo(n, fibo);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] getfibo(int n, int[][] fibo) {
        if (n == 0) {
            return new int[]{1, 0};
        } else if (n == 1) {
            return new int[]{0, 1};
        } else if (fibo[n][0] > 0 || fibo[n][1] > 0) {
            return fibo[n];
        } else {
            int[] before = getfibo(n - 1, fibo);
            int[] before2 = getfibo(n - 2, fibo);
            return fibo[n] = new int[]{before[0] + before2[0], before[1] + before2[1]};
        }
    }
}
