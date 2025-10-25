import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int result = binarySearch(C, houses);
        System.out.println(result);
    }

    private static int binarySearch(int target, int[] houses) {
        int max = 0;
        int lo = 0, hi = houses[houses.length - 1] - houses[0] + 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = getCount(mid, houses);
            if (count >= target) {
                lo = mid + 1;
                max = Math.max(max, mid);
            } else {
                hi = mid;
            }
        }

        return max;
    }

    private static int getCount(int distance, int[] houses) {
        int count = 1;
        int before = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - before >= distance) {
                count++;
                before = houses[i];
            }
        }

        return count;
    }
}
