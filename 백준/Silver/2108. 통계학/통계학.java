import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[8001];
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
            cnt[4000 + num]++;
        }

        int mid_cnt = 0;
        int mid = Integer.MAX_VALUE;

        int mode_cnt = 0;
        int mode = Integer.MAX_VALUE;
        boolean check = false;

        for (int i = min; i <= max; i++) {
            if (cnt[4000 + i] > 0) {

                if (mid_cnt < ((N / 2) + 1)) {
                    mid_cnt += cnt[4000 + i];
                    mid = i;
                }

                if (cnt[4000 + i] > mode_cnt) {
                    mode_cnt = cnt[4000 + i];
                    mode = i;
                    check = true;
                } else if (cnt[4000 + i] == mode_cnt && check) {
                    mode = i;
                    check = false;
                }
            }
        }

        sb.append((Math.round(((double) sum / N)))).append('\n');
        sb.append(mid).append('\n');
        sb.append(mode).append('\n');
        sb.append(max - min).append('\n');
        System.out.println(sb);
    }
}