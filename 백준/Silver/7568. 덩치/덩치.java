import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution(int n, int[] wt, int[] ht) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {

            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                if (wt[j] > wt[i] && ht[j] > ht[i]) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input;
        int[] weight = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input[0]);
            height[i] = Integer.parseInt(input[1]);
        }

        T.solution(n, weight, height);
    }
}