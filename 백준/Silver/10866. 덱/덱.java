import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> Dq = new ArrayDeque<>();

        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    Dq.addFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    Dq.addLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if (Dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(Dq.pollFirst()).append('\n');
                    }
                    break;
                case "pop_back":
                    if (Dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(Dq.pollLast()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(Dq.size()).append('\n');
                    break;
                case "empty":
                    if (Dq.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if (Dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(Dq.peekFirst()).append('\n');
                    }
                    break;
                case "back":
                    if (Dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(Dq.peekLast()).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}