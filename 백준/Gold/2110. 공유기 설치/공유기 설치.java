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

        System.out.println(binarySearch(houses, C));
    }

    public static int binarySearch(int[] houses, int C) {
        // hi를 '불가능한 최소 거리'의 시작점으로 보기 위해 +1
        int lo = 1; 
        int hi = houses[houses.length - 1] - houses[0] + 1; 

        // while (lo < hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 1;
            int lastInstalled = houses[0];
            for (int i = 1; i < houses.length; i++) {
                if (houses[i] - lastInstalled >= mid) {
                    count++;
                    lastInstalled = houses[i];
                }
            }

            if (count >= C) {
                // mid 거리가 가능하므로, 더 큰 거리를 찾아 오른쪽으로
                lo = mid + 1;
            } else {
                // mid 거리가 불가능하므로, hi를 mid로 좁힘
                hi = mid;
            }
        }

        // 루프가 끝나면 lo는 '설치 불가능한 최소 거리'
        // 따라서 가능한 최대 거리는 lo - 1
        return lo - 1;
    }
}