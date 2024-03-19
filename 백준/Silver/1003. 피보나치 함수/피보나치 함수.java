import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Data {
    int zero_cnt, one_cnt;

    public Data(int zero_cnt, int one_cnt) {
        this.zero_cnt = zero_cnt;
        this.one_cnt = one_cnt;
    }
}

public class Main {

    static Data[] dy = new Data[41];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dy[0] = new Data(1, 0);
        dy[1] = new Data(0, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            Data data = dfs(num);
            sb.append(data.zero_cnt).append(' ').append(data.one_cnt).append('\n');
        }

        System.out.println(sb);
    }

    static Data dfs(int n) {
        if (dy[n] != null) return dy[n];
        else {
            Data previous = dfs(n - 1);
            Data twoPrevious = dfs(n - 2);
            return dy[n] = new Data(previous.zero_cnt + twoPrevious.zero_cnt, previous.one_cnt + twoPrevious.one_cnt);
        }
    }
}
