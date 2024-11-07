import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            list.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}