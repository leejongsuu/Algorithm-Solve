import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int solution(int n) {

        int cnt = 1, num = 666;
        while (n!=cnt) {
            num++;

            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(n));
    }
}