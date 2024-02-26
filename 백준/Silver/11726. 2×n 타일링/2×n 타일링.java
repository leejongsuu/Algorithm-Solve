import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] di = new int[n + 1];
        di[0] = 1;
        di[1] = 1;
        for (int i = 2; i <= n; i++) {
            di[i] = (di[i - 2] + di[i - 1]) % 10007;
        }

        System.out.println(di[n]);
    }
}