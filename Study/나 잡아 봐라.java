import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

//        int c = 10;
//        int b = 3;

//        int c = 51;
//        int b = 50;

        int c = 550;
        int b = 500;
        int result = BFS(c, b);
        System.out.println(result);
    }

    private static int BFS(int c, int b) {

        final int INF = 200001;

        int totalTime = 0;
        int temp_c = c;
        while (temp_c < INF) {
            temp_c += totalTime++;
        }

        boolean[][] visited = new boolean[INF][totalTime + 1];
        visited[b][0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(b);

        int time = 0;

        while (c < INF) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int current = queue.poll();
                if (current == c) {
                    return time;
                }

                int[] nextPositions = {current - 1, current + 1, current * 2};
                for (int next : nextPositions) {
                    if (next >= 0 && next < INF && !visited[next][time + 1]) {
                        visited[next][time + 1] = true;
                        queue.offer(next);
                    }
                }
            }

            time++;
            c += time;
        }

        return time;
    }
}
