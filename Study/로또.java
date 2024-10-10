import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] temp = new int[6];

            DFS(0, 0, temp);
            System.out.println();
        }
    }

    private static void DFS(int L, int start, int[] temp) {
        if (L == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append(temp[5]);
            System.out.println(sb);
            return;
        }

        for (int i = start; i < k; i++) {
            temp[L] = arr[i];
            DFS(L + 1, i + 1, temp);
        }
    }
}
