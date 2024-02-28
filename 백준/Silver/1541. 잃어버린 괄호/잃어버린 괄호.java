import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        String[] di = br.readLine().split("-");

        for (int i = 0; i < di.length; i++) {
            int temp = 0;
            String[] split = di[i].split("\\+");

            for (int j = 0; j < split.length; j++) {
                temp += Integer.parseInt(split[j]);
            }
            if (i == 0) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }

}
