import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        final int INF = N * 100_000 + 1;

        int[][] city = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(city[i], INF);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            city[s][e] = Math.min(city[s][e], w);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        city[i][j] = 0;
                        continue;
                    }

                    city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] start : city) {
            for (int end : start) {
                if (end >= INF) {
                    sb.append(0);
                } else {
                    sb.append(end);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}