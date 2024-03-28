import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append('\n');
        }

        System.out.println(sb);
    }

    static String bfs(int A, int target) {

        boolean[] visited = new boolean[10001];
        visited[A] = true;

        Queue<Register> Q = new LinkedList<>();
        Q.offer(new Register(A, ""));

        while (!Q.isEmpty()) {
            Register now = Q.poll();
            if (!visited[now.D()]) {
                int value = now.D();
                String nextCommand = now.command + "D";
                visited[value] = true;
                if (value == target) {
                    return nextCommand;
                } else {
                    Q.offer(new Register(value, nextCommand));
                }
            }

            if (!visited[now.S()]) {
                int value = now.S();
                String nextCommand = now.command + "S";
                visited[value] = true;
                if (value == target) {
                    return nextCommand;
                } else {
                    Q.offer(new Register(value, nextCommand));
                }
            }

            if (!visited[now.L()]) {
                int value = now.L();
                String nextCommand = now.command + "L";
                visited[value] = true;
                if (value == target) {
                    return nextCommand;
                } else {
                    Q.offer(new Register(value, nextCommand));
                }
            }

            if (!visited[now.R()]) {
                int value = now.R();
                String nextCommand = now.command + "R";
                visited[value] = true;
                if (value == target) {
                    return nextCommand;
                } else {
                    Q.offer(new Register(value, nextCommand));
                }
            }
        }

        return "NotFound";
    }

    static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D() {
            return (2 * num) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return ((num % 1000) * 10) + (num / 1000);
        }

        int R() {
            return ((num % 10) * 1000) + num / 10;
        }
    }
}