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
        int M = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        long lt = 0;
        long rt = Arrays.stream(heights).max().getAsInt() + 1;

        while (lt < rt) {
            long mid = lt + (rt - lt) / 2;

            long length = getLength(mid, heights);

            if (length >= M) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        System.out.println(lt - 1);
    }

    public static long getLength(long mid, int[] heights) {
        long result = 0;

        for (int height : heights) {
            if (height > mid) {
                result += (int) (height - mid);
            }
        }

        return result;
    }
}