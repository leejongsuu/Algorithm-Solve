import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(solution(i, j)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(int i, int j) {
        
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        
        Q.offer(i);
        while (!Q.isEmpty()) {
            int current = Q.poll();
            for (int num : graph.get(current)) {
                if (visited[num]) continue;
                if (num == j) {
                    return 1;
                } else {
                    visited[num] = true;
                    Q.offer(num);
                }
            }
        }

        return 0;
    }
}