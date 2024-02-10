import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] prime;

    public static void get_prime(int n) {
        //true : 소수X , false = 소수
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) continue;
            for (int j = i; i * j <= n; j++) {
                prime[i * j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        prime = new boolean[N + 1];

        get_prime(N);

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}