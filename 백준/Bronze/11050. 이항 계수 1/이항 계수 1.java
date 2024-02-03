import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int solution(int n, int k) {

        int sum = 1;

        for (int i = 0; i < k; i++) {
            sum *= n;
            n--;
        }

        for (int i = k; i > 1; i--) {
            sum /= i;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(T.solution(N, K));
    }
}