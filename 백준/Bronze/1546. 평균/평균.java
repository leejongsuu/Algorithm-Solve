import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public double solution(int n, int[] arr) {

        double answer = 0;
        double M = Arrays.stream(arr).max().getAsInt();

        for (int score : arr) {
            answer += (score / M) * 100;
        }

        return answer / n;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        System.out.println(T.solution(n, arr));
    }
}