import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] subtraction = br.readLine().split("-");

        int sum = 0;

        for (int i = 0; i < subtraction.length; i++) {

            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더함.
            String[] addition = subtraction[i].split("\\+");

            for (String s : addition) {
                temp += Integer.parseInt(s);
            }
            if (i == 0) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
