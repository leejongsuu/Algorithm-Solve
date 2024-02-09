import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] Queue;
    static int lt = -1, rt = -1;

    public static void push(int x) {
        Queue[++rt] = x;
    }

    public static int pop() {
        if (size() > 0) {
            return Queue[++lt];
        } else {
            return -1;
        }
    }

    public static int size() {
        if ((rt - lt) <= 0) {
            return 0;
        } else {
            return rt - lt;
        }
    }

    public static int empty() {
        if (size() > 0) return 0;
        else return 1;
    }

    public static int front() {
        if (size() > 0) {
            return Queue[lt + 1];
        } else {
            return -1;
        }
    }

    public static int back() {
        if (size() > 0) {
            return Queue[rt];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue = new int[n];

        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}