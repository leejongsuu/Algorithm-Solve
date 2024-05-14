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
        while (num > 0) {
            Union(0, Integer.parseInt(st.nextToken()));
            num--;
        }

        int[][] party = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            party[i] = new int[Integer.parseInt(st.nextToken())];
            for (int j = 0; j < party[i].length; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < party[i].length; j++) {
                Union(party[i][j - 1], party[i][j]);
            }
        }

        int count = M;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < party[i].length; j++) {
                if (Find(0) == Find(party[i][j])) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    private static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    private static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
}
