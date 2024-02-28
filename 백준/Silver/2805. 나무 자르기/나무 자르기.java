import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if (max < tree[i]) {
                max = tree[i];
            }
        }

        System.out.println(solution(max, M, tree));
    }

    static long solution(int hi, int m, int[] tree) {

        int lo = 0;

        while (lo < hi) {
            
            int mid = (lo + hi) / 2;
            long sum = 0;

            for (int h : tree) {
                if (h - mid > 0) {
                    sum += h - mid;
                }
            }

            if (sum < m) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo - 1;
    }

}
