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

        int max = 0;
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) {
                max = tree[i];
            }
        }

        System.out.println(binarySearch(max, M, tree));
    }

    static int binarySearch(int hi, int M, int[] tree) {

        int lo = 0;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            long sum = 0;
            for (int i = 0; i < tree.length; i++) {
                int sub = tree[i] - mid;
                if (sub > 0) {
                    sum += sub;
                }
            }

            if (sum < M) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }
}





