import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int sum = 0;

            String token = st.nextToken();
            String[] parts = token.split("[+]");
            for (String part : parts) {
                sum += Integer.parseInt(part);
            }

            list.add(sum);
        }

        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }

        System.out.println(result);
    }
}
