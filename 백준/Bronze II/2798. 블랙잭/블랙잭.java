import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m, answer = Integer.MIN_VALUE;
    static int[] arr;

    public void solution(int L, int start, int sum) {

        if (sum > m || answer == m) return;

        if (L == 3) {
            answer = Math.max(answer, sum);
        } else {
            for (int i = start; i < n; i++) {
                solution(L + 1, i + 1, sum + arr[i]);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        arr = new int[n];
        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        T.solution(0, 0, 0);
        System.out.println(answer);
    }
}