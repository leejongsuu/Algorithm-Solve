import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            if (N > 32) {
                sb.append(0).append('\n');
                continue;
            }

            int min = getMin(N, str);

            sb.append(min).append('\n');
        }

        System.out.println(sb);
    }

    private static int getMin(int N, String[] str) {

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < N - 2; j++) {
            for (int k = j + 1; k < N - 1; k++) {
                for (int l = k + 1; l < N; l++) {
                    int cnt = 0;
                    for (int x = 0; x < 4; x++) {
                        cnt += str[j].charAt(x) == str[k].charAt(x) ? 0 : 1;
                        cnt += str[j].charAt(x) == str[l].charAt(x) ? 0 : 1;
                        cnt += str[k].charAt(x) == str[l].charAt(x) ? 0 : 1;
                    }
                    min = Math.min(min, cnt);
                    if (min == 0) break;
                }
            }
        }
        
        return min;
    }
}
