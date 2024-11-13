import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;
        int n = Integer.parseInt(br.readLine());

        for (long i = 666; ; i++) {
            if (String.valueOf(i).contains("666")) {
                n--;
            }

            if (n <= 0) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}