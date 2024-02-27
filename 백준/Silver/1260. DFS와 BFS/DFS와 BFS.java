import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] arr;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int n) {
        ch[n] = 1;
        sb.append(n).append(' ');
        for (int i = 1; i <= N; i++) {
            if (arr[n][i] == 1 && ch[i] == 0) {
                DFS(i);
            }
        }
    }

    static void BFS(int n) {

        Queue<Integer> Q = new LinkedList<>();

        Q.offer(n);
        while (!Q.isEmpty()) {
            Integer p = Q.poll();
            if (ch[p] == 1) continue;
            ch[p] = 1;
            sb.append(p).append(' ');
            for (int i = 1; i <= N; i++) {
                if (arr[p][i] == 1 && ch[i] == 0) {
                    Q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        ch = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        DFS(V);
        System.out.println(sb);

        Arrays.fill(ch, 0);
        sb = new StringBuilder();

        BFS(V);
        System.out.println(sb);
    }
}
