import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(houses[0]);
            return;
        }

        Arrays.sort(houses);

        if (N % 2 == 1) {
            System.out.println(houses[N / 2]);
        } else {
            int first = houses[N / 2 - 1];
            int second = houses[N / 2];

            int sum1 = 0;
            int sum2 = 0;
            for (int h : houses) {
                sum1 += Math.abs(h - first);
                sum2 += Math.abs(h - second);
            }

            if (sum1 <= sum2) {
                System.out.println(first);
            } else {
                System.out.println(second);
            }
        }
    }
}