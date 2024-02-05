import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public int solution(int n) {

        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(T.solution(N));
    }
}