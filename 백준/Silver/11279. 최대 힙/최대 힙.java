import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (pQ.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pQ.poll()).append('\n');
                }
            } else {
                pQ.offer(value);
            }

        }
        System.out.println(sb);
    }
}
