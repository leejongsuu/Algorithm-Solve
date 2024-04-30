import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] minDP = new int[3];
        int[] maxDP = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            minDP[i] = maxDP[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] minNext = new int[3];
            int[] maxNext = new int[3];
            int[] current = new int[3];

            for (int j = 0; j < 3; j++) {
                current[j] = Integer.parseInt(st.nextToken());
            }

            minNext[0] = Math.min(minDP[0], minDP[1]) + current[0];
            maxNext[0] = Math.max(maxDP[0], maxDP[1]) + current[0];

            minNext[1] = Math.min(Math.min(minDP[0], minDP[1]), minDP[2]) + current[1];
            maxNext[1] = Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]) + current[1];

            minNext[2] = Math.min(minDP[1], minDP[2]) + current[2];
            maxNext[2] = Math.max(maxDP[1], maxDP[2]) + current[2];

            minDP = minNext;
            maxDP = maxNext;
        }

        int minScore = Math.min(Math.min(minDP[0], minDP[1]), minDP[2]);
        int maxScore = Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]);

        System.out.println(maxScore + " " + minScore);
    }
}