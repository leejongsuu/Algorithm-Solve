import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] numbers;
    static int[] operand;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operand = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operand[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int L, int sum) {
        if (L == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operand[i] > 0) {
                int result = calculate(sum, numbers[L], i);
                operand[i]--;
                dfs(L + 1, result);
                operand[i]++;
            }
        }
    }

    private static int calculate(int a, int b, int k) {
        switch (k) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                if (a < 0) {
                    return ((a * -1) / b) * -1;
                }
                return a / b;
        }
        return -1;
    }
}