import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[10001];

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            while (cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }

        System.out.println(sb);
    }
}