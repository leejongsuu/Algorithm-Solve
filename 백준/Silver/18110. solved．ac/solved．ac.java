import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int solution(int n, int[] arr) {

        int answer = 0;

        double avg = n *  (15.0 / 100);
        int cnt = (int) Math.round(avg);

        Arrays.sort(arr);

        for (int i = cnt; i < n - cnt; i++) {
            answer += arr[i];
        }

        answer = (int) Math.round((double) answer / (n - (cnt * 2)));
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n, arr));
    }
}