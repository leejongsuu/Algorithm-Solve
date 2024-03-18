import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, String> map1 = new HashMap<>(N);
        HashMap<String, String> map2 = new HashMap<>(N);

        for (int i = 1; i <= N; i++) {
            String data = br.readLine();
            map1.put(data, String.valueOf(i));
            map2.put(String.valueOf(i), data);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String search = br.readLine();
            if (Character.isDigit(search.charAt(0))) {
                sb.append(map2.get(search)).append('\n');
            } else {
                sb.append(map1.get(search)).append('\n');
            }
        }

        System.out.println(sb);
    }


}



