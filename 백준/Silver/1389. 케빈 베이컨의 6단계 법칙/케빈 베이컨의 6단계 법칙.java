import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        int minValue = Integer.MAX_VALUE;
        int answer = 1;

        for (int i = 1; i <= N; i++) {
            int num = bfs(i, N, minValue, list);
            if (num < minValue) {
                minValue = num;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    static int bfs(int v, int n, int min, ArrayList<ArrayList<Integer>> list) {

        boolean[] visited = new boolean[n + 1];
        visited[v] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        int sum = 0;
        int level = 1;

        while (!queue.isEmpty()) {
            if (sum >= min) {
                return Integer.MAX_VALUE;
            }

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                for (int x : list.get(now)) {
                    if (!visited[x]) {
                        visited[x] = true;
                        sum += level;
                        queue.offer(x);
                    }
                }
            }
            level++;
        }

        return sum;
    }
}