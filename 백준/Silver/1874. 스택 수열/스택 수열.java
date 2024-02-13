import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static String solution(int n, int max, int[] arr) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int lt = 0;
        for (int rt = 1; rt <= max; rt++) {
            stack.push(rt);
            sb.append('+').append('\n');
            while (lt < n && !stack.isEmpty() && arr[lt] == stack.peek()) {
                stack.pop();
                lt++;
                sb.append('-').append('\n');
            }
        }
        if (!stack.isEmpty()) return "NO";
        else return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(solution(n, max, arr));
    }
}