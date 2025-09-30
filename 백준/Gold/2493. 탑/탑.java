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

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] topHeights = new int[N];
        for (int i = 0; i < N; i++) {
            topHeights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<TOP> stack = new Stack<>();

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek().height < topHeights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek().index;
            }
            stack.push(new TOP(i + 1, topHeights[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}