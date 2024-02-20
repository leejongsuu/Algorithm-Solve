import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashMap<Integer, String> IndexMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();


        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            nameMap.put(str, i);
            IndexMap.put(i, str);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                sb.append(IndexMap.get(Integer.parseInt(str))).append('\n');
            } else {
                sb.append(nameMap.get(str)).append('\n');
            }
        }
        br.close();

        System.out.println(sb);
    }
}