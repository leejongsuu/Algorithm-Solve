import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int solution(int n) {

        int cnt = 1;
        int range = 2;

        while (range <= n) {
            range += cnt * 6;
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(n));
    }
}

