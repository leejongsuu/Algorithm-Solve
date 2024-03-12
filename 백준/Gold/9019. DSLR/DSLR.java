import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Register {
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
        return (num % 1000) * 10 + num / 1000;
    }

    int R() {
        return (num / 10) + ((num % 10) * 1000);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            sb.append(solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]))).append('\n');
        }

        System.out.println(sb);
    }

    static String solution(int a, int b) {

        boolean[] visited = new boolean[10000];
        visited[a] = true;

        Queue<Register> Q = new LinkedList<>();
        Q.offer(new Register(a, ""));

        String answer = "";
        while (!Q.isEmpty()) {
            Register now = Q.poll();

            if (now.num == b) {
                answer = now.command;
                break;
            }

            if (!visited[now.D()]) {
                visited[now.D()] = true;
                Q.offer(new Register(now.D(), now.command + "D"));
            }

            if (!visited[now.S()]) {
                visited[now.S()] = true;
                Q.offer(new Register(now.S(), now.command + "S"));
            }

            if (!visited[now.L()]) {
                visited[now.L()] = true;
                Q.offer(new Register(now.L(), now.command + "L"));
            }

            if (!visited[now.R()]) {
                visited[now.R()] = true;
                Q.offer(new Register(now.R(), now.command + "R"));
            }
        }
        return answer;
    }
}

