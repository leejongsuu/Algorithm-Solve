import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution(int n, int m) {

        int i = 2, maxCommon = 1;

        while (i <= Math.min(n, m)) {
            if (n % i == 0 && m % i == 0) {
                maxCommon *= i;
                n /= i;
                m /= i;
            } else {
                i++;
            }
        }

        System.out.println(maxCommon);
        System.out.println(maxCommon * n * m);
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        T.solution(n, m);
    }
}