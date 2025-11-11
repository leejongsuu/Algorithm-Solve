import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (find(1) == find(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) unf[fa] = fb;
    }

    public static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}
