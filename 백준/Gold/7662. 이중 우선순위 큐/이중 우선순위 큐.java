import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tMap = new TreeMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    tMap.put(num, tMap.getOrDefault(num, 0) + 1);
                } else {
                    if (tMap.isEmpty()) {
                        continue;
                    }

                    if (num == 1) {
                        Integer key = tMap.lastKey();
                        if (tMap.get(key) == 1) {
                            tMap.remove(key);
                        } else {
                            tMap.put(key, tMap.get(key) - 1);
                        }
                    } else if (num == -1) {
                        Integer key = tMap.firstKey();
                        if (tMap.get(key) == 1) {
                            tMap.remove(key);
                        } else {
                            tMap.put(key, tMap.get(key) - 1);
                        }
                    }
                }
            }
            if (tMap.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(tMap.lastKey()).append(" ").append(tMap.firstKey()).append('\n');
            }
        }
        System.out.println(sb);
    }
}

