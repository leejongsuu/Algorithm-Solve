import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int solution(int n) {

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (Q.size() != 1) {
            Q.poll();
            Q.offer(Q.poll());
        }

        return Q.poll();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}