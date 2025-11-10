import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<String, String> pocketmonMap = new HashMap<>();
        Map<String, String> pocketmonMap2 = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            pocketmonMap.put(name, String.valueOf(i + 1));
            pocketmonMap2.put(String.valueOf(i + 1), name);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (pocketmonMap.containsKey(key)) {
                sb.append(pocketmonMap.get(key)).append('\n');
            } else {
                sb.append(pocketmonMap2.get(key)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
