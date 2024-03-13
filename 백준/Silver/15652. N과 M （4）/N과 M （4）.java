import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];

        dfs(0, 1);

        System.out.println(sb);
    }

    static void dfs(int L, int start) {
        if (L == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = start; i <= N; i++) {
                arr[L] = i;
                dfs(L + 1, i);
            }
        }
    }
}