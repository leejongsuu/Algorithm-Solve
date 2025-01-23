import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int zeroToOneCount = 0;
        int oneToZeroCount = 0;

        if (input.charAt(0) == '0') {
            zeroToOneCount++;
        } else {
            oneToZeroCount++;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '1') {
                    oneToZeroCount++;
                } else {
                    zeroToOneCount++;
                }
            }
        }

        System.out.println(Math.min(oneToZeroCount, zeroToOneCount));
    }
}