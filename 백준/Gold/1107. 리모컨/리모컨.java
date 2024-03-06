import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (M > 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(input[i])] = true;
            }
        }

        int result = getResult(N, broken);

        System.out.println(result);
    }

    private static int getResult(int N, boolean[] broken) {
        int result = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean check = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                int min = Math.abs(N - i) + len;
                result = Math.min(result, min);
            }
        }
        return result;
    }
}
