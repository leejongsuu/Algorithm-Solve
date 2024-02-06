import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public void solution(int n, int k) {

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.offer(i);

        while (!Q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                Q.offer(Q.poll());
            }
            sb.append(Q.poll()).append(',').append(' ');
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        T.solution(n, k);
    }
}