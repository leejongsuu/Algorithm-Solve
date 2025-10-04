import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class TOP {
        int index, height;

        TOP(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<TOP> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().height <= height) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek().height > height) {
                result[i] = stack.peek().index;
            }

            stack.push(new TOP(i + 1, height));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}