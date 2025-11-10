import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, i);
        }

        TreeSet<String> answer = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                answer.add(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');

        for (String s : answer) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}



