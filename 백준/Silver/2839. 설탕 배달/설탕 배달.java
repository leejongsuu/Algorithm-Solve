import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int solution(int n) {

        int[] salt = new int[n + 1];
        int[] bag = {3, 5};
        Arrays.fill(salt, Integer.MAX_VALUE);

        salt[0] = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = bag[i]; j <= n; j++) {
                if (salt[j-bag[i]]==Integer.MAX_VALUE) continue;
                salt[j] = Math.min(salt[j], salt[j - bag[i]] + 1);
            }
        }

        return salt[n] == Integer.MAX_VALUE ? -1 : salt[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}