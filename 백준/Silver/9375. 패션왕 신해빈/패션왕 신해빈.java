import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static int solution(String[] str) {

        int sum = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        for (Integer value : map.values()) {
            sum *= (value + 1);
        }
        
        return sum - 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] str = new String[N];
            for (int j = 0; j < N; j++) {
                str[j] = br.readLine().split(" ")[1];
            }
            sb.append(solution(str)).append('\n');
        }

        System.out.println(sb);
    }
}