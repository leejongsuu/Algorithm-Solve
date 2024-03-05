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
                int num = solution(i, j);
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(int i, int j) {

        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[N];

        Q.offer(i);
        while (!Q.isEmpty()) {
            int current = Q.poll();
            for (int num : graph.get(current)) {
                if (ch[num] == 1) continue;
                if (num == j) {
                    return 1;
                } else {
                    ch[num] = 1;
                    Q.offer(num);
                }
            }
        }

        return 0;
    }
}
