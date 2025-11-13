import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long lt = 1;
        long rt = (long) Arrays.stream(arr).max().getAsInt() + 1;

        while (lt < rt) {
            long mid = lt + (rt - lt) / 2;

            int count = getCount(mid, arr);
            if (count >= N) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        System.out.println(lt - 1);
    }

    public static int getCount(long mid, int[] arr) {
        int count = 0;
        for (int a : arr) {
            count += (int) (a / mid);
        }
        return count;
    }
}
