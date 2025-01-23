import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sequence = new int[N];
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
            numbers[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, j = 0; i < N; ) {
            while (j < N && numbers[j] <= sequence[i]) {
                stack.push(numbers[j]);
                sb.append('+').append('\n');
                j++;
            }
            while (!stack.isEmpty() && stack.peek() == sequence[i]) {
                stack.pop();
                sb.append('-').append('\n');
                i++;
            }
            if (!stack.isEmpty() && stack.peek() > sequence[i]) {
                System.out.println("NO");
                return;
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}