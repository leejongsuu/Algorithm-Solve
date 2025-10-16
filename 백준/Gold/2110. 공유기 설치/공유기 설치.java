import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 2 4 8 9
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        System.out.println(binarySearch(houses, C));
    }

    public static int binarySearch(int[] houses, int C) {
        int lo = 0;
        int hi = houses[houses.length - 1] - houses[0];
        int max = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 1;
            int lastInstalled = houses[0];

            for (int i = 1; i < houses.length; i++) {
                int dis = houses[i] - lastInstalled;
                if (dis >= mid) {
                    lastInstalled = houses[i];
                    count++;
                }
                if (count == C) break;
            }

            if (count >= C) {
                max = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return max;
    }
}