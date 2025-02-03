import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, chickenSize, answer = Integer.MAX_VALUE;
    static int[] combination;
    static ArrayList<Point> homeList = new ArrayList<>();
    static ArrayList<Point> chickenList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) homeList.add(new Point(i, j));
                else if (num == 2) chickenList.add(new Point(i, j));
            }
        }

        combination = new int[M];
        chickenSize = chickenList.size();

        DFS(0, 0);

        System.out.println(answer);
    }

    private static void DFS(int L, int start) {
        if (L == M) {
            answer = Math.min(answer, calculate_distance(combination));
            return;
        }

        for (int i = start; i < chickenSize; i++) {
            combination[L] = i;
            DFS(L + 1, i + 1);
        }
    }

    private static int calculate_distance(int[] combination) {

        int sum_distance = 0;
        for (Point h : homeList) {
            int min_distance = Integer.MAX_VALUE;
            for (int i : combination) {
                Point c = chickenList.get(i);
                min_distance = Math.min(min_distance, Math.abs(h.y - c.y) + Math.abs(h.x - c.x));
            }
            sum_distance += min_distance;
        }

        return sum_distance;
    }
}
