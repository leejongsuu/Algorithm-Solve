import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Docs {
        int index;
        int priority;

        public Docs(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static int solution(int n, int m, int[] arr, Queue<Docs> queue) {

        Arrays.sort(arr);

        int i = 1;
        while (!queue.isEmpty()) {
            Docs current = queue.poll();
            if (current.priority == arr[n - i]) {
                if (current.index == m) {
                    return i;
                }
                i++;
                continue;
            }
            queue.offer(current);
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            Queue<Docs> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                int pri = Integer.parseInt(st.nextToken());
                arr[j] = pri;
                queue.offer(new Docs(j, pri));
            }

            int result = solution(n, m, arr, queue);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}