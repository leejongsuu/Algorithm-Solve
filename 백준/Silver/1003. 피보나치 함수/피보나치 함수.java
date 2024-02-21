import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class fibo {
    int x, y;

    public fibo(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static fibo[] answer = new fibo[41];

    public static fibo DFS(int n) {
        if (answer[n]!=null) return answer[n];

        if (n == 0) {
            answer[0] = new fibo(1, 0);
            return answer[0];
        } else if (n == 1) {
            answer[1] = new fibo(0, 1);
            return answer[1];
        } else {
            fibo prev1 = DFS(n - 1);
            fibo prev2 = DFS(n - 2);
            answer[n] = new fibo(prev1.x + prev2.x, prev1.y + prev2.y);
            return answer[n];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo value = DFS(n);
            sb.append(value.x).append(' ').append(value.y).append('\n');
        }

        System.out.println(sb);
    }
}