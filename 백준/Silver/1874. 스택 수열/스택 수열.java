import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int lt = 0;
        for (int rt = 1; rt <= N; rt++) {
            stack.push(rt);
            sb.append('+').append('\n');
            while (lt < N && !stack.isEmpty() && stack.peek() >= sequence[lt]) {
                stack.pop();
                sb.append('-').append('\n');
                lt++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb.deleteCharAt(sb.length() - 1));
        } else {
            System.out.println("NO");
        }
    }
}