import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N + 1];

        dfs(0, 1);

        System.out.println(sb);
    }

    static void dfs(int L, int start) {
        if (L == M) {
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (arr[i] != 0) {
                    sb.append(arr[i]).append(' ');
                    cnt++;
                }

                if (cnt == M) break;
            }
            sb.append('\n');
        } else {
            for (int i = start; i <= N; i++) {
                arr[i] = i;
                dfs(L + 1, i + 1);
                arr[i] = 0;
            }
        }
    }
}

