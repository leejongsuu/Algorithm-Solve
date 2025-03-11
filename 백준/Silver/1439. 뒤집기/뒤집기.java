import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        int oneToZeroCount = 0;
        int zeroToOneCount = 0;

        if (ch[0] == '0') {
            zeroToOneCount++;
        } else {
            oneToZeroCount++;
        }

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] != ch[i - 1]) {
                if (ch[i] == '0') {
                    zeroToOneCount++;
                } else {
                    oneToZeroCount++;
                }
            }
        }

        System.out.println(Math.min(zeroToOneCount, oneToZeroCount));
    }
}
