import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        System.out.println(BFS(N, K));
    }

    private static int BFS(int n, int k) {
        int len = 100001;
        int[] visited = new int[len];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[n] = 0;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(n, 0));

        int minTime = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Info current = queue.poll();
            if(current.time >= minTime) continue;

            if (current.pos == k) {
                minTime = current.time;
            }

            // 순간이동 처리
            int nextPos = current.pos * 2;
            int nextTime = current.time;
            if (nextPos < len && nextTime < visited[nextPos]) {
                visited[nextPos] = nextTime;
                queue.add(new Info(nextPos, current.time));
            }

            // 한 칸 앞으로 이동 처리
            nextPos = current.pos + 1;
            nextTime = current.time + 1;
            if (nextPos < len && nextTime < visited[nextPos]) {
                visited[nextPos] = nextTime;
                queue.add(new Info(nextPos, current.time + 1));
            }

            // 한 칸 뒤로 이동 처리
            nextPos = current.pos - 1;
            nextTime = current.time + 1;
            if (nextPos >= 0 && nextTime < visited[nextPos]) {
                visited[nextPos] = nextTime;
                queue.add(new Info(nextPos, current.time + 1));
            }
        }

        return minTime; // 도달할 수 없는 경우
    }

    static class Info {
        int pos, time;

        public Info(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
