import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] unf;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a, b);
        }

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (Find(1) == Find(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    static int Find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = Find(unf[v]);
    }
}
