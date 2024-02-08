import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] nInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(nInput[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        String[] mInput = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(mInput[i]);
            if (map.get(key) == null) {
                sb.append(0).append(' ');
            } else {
                sb.append(map.get(key)).append(' ');
            }
        }

        System.out.println(sb);
    }
}