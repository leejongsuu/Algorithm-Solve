import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());


        while (st.hasMoreTokens()) {
            union(0, Integer.parseInt(st.nextToken()));
        }

        int[][] party = new int[M][];
        for (
                int i = 0;
                i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            party[i] = new int[p];

            for (int j = 0; j < p; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < p - 1; j++) {
                union(party[i][j], party[i][j + 1]);
            }
        }

        int count = M;
        for (
                int i = 0;
                i < M; i++) {
            for (int j = 0; j < party[i].length; j++) {
                if (find(0) == find(party[i][j])) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    private static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}
