import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String str = br.readLine();
            if (str.charAt(0)=='0') break;

            if (str.contentEquals(new StringBuffer(str).reverse())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}