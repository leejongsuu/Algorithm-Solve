import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int solution (int n) {

        if(n==1) return 1;
        else {
            int cnt = 1, i = 1, lt = 2, rt = 7;
            while (lt <= n) {
                cnt++;
                if (lt <= n && rt >= n) {
                    return cnt;
                } else {
                    lt += 6 * i;
                    rt += 6 * (i + 1);
                    i++;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(n));

    }
}

