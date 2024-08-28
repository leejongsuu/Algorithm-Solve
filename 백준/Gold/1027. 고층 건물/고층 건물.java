import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] buildings = new int[n];
        int[] canSee = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            double max_inc = -Double.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                double inc = getInc(i, buildings[i], j, buildings[j]);
                if (inc > max_inc) {
                    canSee[i]++;
                    canSee[j]++;
                    max_inc = inc;
                }
            }
            max = Math.max(max, canSee[i]);
        }

        System.out.println(max);
    }

    private static double getInc(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}