import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solution(String str) {

        int len = str.length();
        int num = Integer.parseInt(str);

        for (int i = (num - (9 * len)); i < num; i++) {
            int value = i;
            int sum = i;
            while (value != 0) {
                sum += value % 10;
                value /= 10;
            }

            if (sum == num) return i;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(solution(input));
    }
}