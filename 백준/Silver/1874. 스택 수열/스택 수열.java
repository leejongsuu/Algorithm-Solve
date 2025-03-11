import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, num = 1; i < N; i++) {
            for (; num <= sequence[i]; num++) {
                stack.push(num);
                sb.append('+').append('\n');
            }

            if (stack.isEmpty() || stack.peek() != sequence[i]) {
                System.out.println("NO");
                return;
            }

            sb.append('-').append('\n');
            stack.pop();
        }

        System.out.println(sb);
    }
}