import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, max = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, new int[n]);

        System.out.println(max);
    }

    private static void DFS(int L, int[] temp) {

        if (L == n) {
            max = Math.max(max, calculate(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[L] = arr[i];
                DFS(L + 1, temp);
                visited[i] = false;
            }
        }
    }

    private static int calculate(int[] temp) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(temp[i + 1] - temp[i]);
        }
        return sum;
    }
}