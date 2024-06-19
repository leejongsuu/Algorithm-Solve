import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final int INF = 100 * 15 + 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int[][] region = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                region[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (w < region[s][e]) {
                region[s][e] = w;
                region[e][s] = w;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int distance = region[i][k] + region[k][j];
                    if (distance < region[i][j]) {
                        region[i][j] = distance;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (region[i][j] <= m) {
                    sum += item[j];
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
