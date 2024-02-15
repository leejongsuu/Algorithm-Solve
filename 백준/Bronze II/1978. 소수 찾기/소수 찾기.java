import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean solution(int num) {

        if (num < 2) return false;
        else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        int cnt = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < T; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (solution(tmp)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}