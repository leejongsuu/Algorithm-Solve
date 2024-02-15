import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        int[][] arr = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if (arr[i][j] > max) max = arr[i][j];
                if (arr[i][j] < min) min = arr[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int i = min; i <= max; i++) {
            int block = b;
            int temporal = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j][k] > i) {
                        temporal += ((arr[j][k] - i) * 2);
                        block += (arr[j][k] - i);
                    } else if (arr[j][k] < i) {
                        temporal += (i - arr[j][k]);
                        block -= (i - arr[j][k]);
                    }
                }
            }

            if (block < 0) continue;

            if (temporal <= time) {
                time = temporal;
                height = i;
            }
        }
        System.out.println(time + " " + height);
    }
}