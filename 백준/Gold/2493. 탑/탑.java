import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] topHeights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            topHeights[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(N, topHeights);

        StringBuilder sb = new StringBuilder();

        for (int i : result) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static class Top {
        int index;
        int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static int[] solution(int n, int[] topHeights) {
        int[] arr = new int[n];

        Stack<Top> stack = new Stack<>();
        stack.push(new Top(1, topHeights[0]));

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().height < topHeights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                arr[i] = stack.peek().index;
            }
            stack.push(new Top(i + 1, topHeights[i]));
        }

        return arr;
    }
}