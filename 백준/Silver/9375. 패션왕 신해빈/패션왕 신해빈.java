import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static int solution(String[] strArr) {

        int sum = 1; //모든 의상을 선택하지 않는 경우를 고려하여 1로 초기화.

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strArr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Integer value : map.values()) {
            sum *= (value + 1); // 각 의상 종류를 선택하지 않는 경우를 고려하여 1을 더함.
        }

        return sum - 1; // 모든 의상을 선택하지 않는 경우를 제외.
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            String[] input = new String[N];

            for (int j = 0; j < N; j++) {
                input[j] = br.readLine().split(" ")[1];
            }

            sb.append(solution(input)).append('\n');
        }

        System.out.println(sb);
    }
}