import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr, answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        DFS(0);

        System.out.println(sb);
    }

    static void DFS(int L) {

        if (L == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int before = -1;
        for (int i = 0; i < N; i++) {

            if (visited[i]) continue;

            if (before != arr[i]) {
                visited[i] = true;
                answer[L] = arr[i];
                before = arr[i];
                DFS(L + 1);
                visited[i] = false;
            }
        }
    }
}