import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result = Integer.MAX_VALUE;
    static int[][] city;
    static List<int[]> houses, chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) houses.add(new int[]{i, j});
                else if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(0, 0, new int[M]);

        System.out.println(result);
    }

    private static void dfs(int L, int start, int[] combi) {
        if (L == M) {
            int distance = getDistance(combi);
            result = Math.min(result, distance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            combi[L] = i;
            dfs(L + 1, i + 1, combi);
        }
    }

    private static int getDistance(int[] combi) {
        int sum = 0;
        for (int[] house : houses) {
            int distance = Integer.MAX_VALUE;
            for (int c : combi) {
                int[] chicken = chickens.get(c);
                distance = Math.min(distance, Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]));
            }
            sum += distance;
        }
        return sum;
    }
}