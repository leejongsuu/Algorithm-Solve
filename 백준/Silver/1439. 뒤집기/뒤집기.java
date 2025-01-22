import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int len = S.length();

        int countToAllZero = 0;
        int countToAllOne = 0;

        if (S.charAt(0) == '1') {
            countToAllZero++;
        } else {
            countToAllOne++;
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                if (S.charAt(i + 1) == '1') {
                    countToAllZero++;
                } else {
                    countToAllOne++;
                }
            }
        }

        System.out.println(Math.min(countToAllZero, countToAllOne));
    }
}