import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] plain = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                plain[i][j] = Integer.parseInt(st.nextToken());
                if (plain[i][j] < min) {
                    min = plain[i][j];
                } else if (plain[i][j] > max) {
                    max = plain[i][j];
                }
            }
        }

        int maxHeight = 0;
        int minTime = Integer.MAX_VALUE;

        for (int h = min; h <= max; h++) {
            int toUp = 0;
            int toDown = 0;

            for (int[] arr : plain) {
                for (int num : arr) {
                    if (h > num) {
                        toUp += h - num;
                    } else if (h < num) {
                        toDown += num - h;
                    }
                }
            }

            int b = B + toDown;

            if (toUp > b) {
                continue;
            }

            int time = toDown * 2 + toUp;

            if (time <= minTime) {
                minTime = time;
                maxHeight = h;
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }
}