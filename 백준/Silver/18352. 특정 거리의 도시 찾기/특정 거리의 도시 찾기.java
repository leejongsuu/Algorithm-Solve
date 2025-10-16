import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[X] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);

        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (dis == K) {
                break;
            }

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int next : adjList[current]) {
                    if (dp[current] + 1 < dp[next]) {
                        dp[next] = dp[current] + 1;
                        queue.offer(next);
                    }
                }
            }

            dis++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dp[i] == K) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.length() == 0 ? "-1" : sb.toString());
    }
}