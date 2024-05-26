import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] result = BFS(N, K);

        System.out.println(result[0] + "\n" + result[1]);
    }

    private static int[] BFS(int n, int k) {

        final int INF = 200001;
        boolean[] visited = new boolean[INF];
        boolean flag = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        int time = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                visited[current] = true;

                if (current == k) {
                    flag = true;
                    cnt++;
                    continue;
                }

                int next = current - 1;
                if (next >= 0 && !visited[next]) {
                    queue.add(next);
                }

                if (n < k) {
                    next = current + 1;
                    if (next < INF && !visited[next]) {
                        queue.add(next);
                    }

                    next = current * 2;
                    if (next < INF && !visited[next]) {
                        queue.add(next);
                    }
                }
            }
            
            if (flag) return new int[]{time, cnt};
            time++;
        }
        return new int[]{-1, -1};
    }
}
