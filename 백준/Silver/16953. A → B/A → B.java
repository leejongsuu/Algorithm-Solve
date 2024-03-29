import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[M + 1];

        DFS(1, N);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void DFS(int L, int num) {

        if (num > M || L > answer) return;

        int value = Func1(num);
        int value2 = Func2(num);

        if (value == M || value2 == M) {
            answer = L + 1;
            return;
        }

        if (value < M && !visited[value]) {
            visited[value] = true;
            DFS(L + 1, value);
        }

        if (value2 < M && !visited[value2]) {
            visited[value2] = true;
            DFS(L + 1, value2);
        }
    }

    static int Func1(int n) {
        long result = (2L * n) % Integer.MAX_VALUE;
        return (int) result;
    }

    static int Func2(int n) {
        long result = (10L * n + 1) % Integer.MAX_VALUE;
        return (int) result;
    }
}