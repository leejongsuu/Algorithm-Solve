import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String score = br.readLine();
        int mid = score.length() / 2;

        String front = score.substring(0, mid);
        String back = score.substring(mid);

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < mid; i++) {
            sum1 += front.charAt(i) - '0';
            sum2 += back.charAt(i) - '0';
        }

        System.out.println(sum1 == sum2 ? "LUCKY" : "READY");
    }
}