import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] unf;

    static int Find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Union(s, e);
        }

        System.out.println(solution(N));
    }

    static int solution(int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int value = Find(i);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        return map.size();
    }
}
