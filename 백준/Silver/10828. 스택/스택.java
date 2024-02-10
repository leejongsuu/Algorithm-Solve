import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int index = -1;

    public static void push(int x) {
        arr[++index] = x;
    }

    public static int pop() {
        if (size() > 0) {
            return arr[index--];
        } else {
            return -1;
        }
    }

    public static int size() {
        return index + 1;
    }

    public static int empty() {
        if (size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (size() > 0) {
            return arr[index];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push" :
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop" :
                    sb.append(pop()).append('\n');
                    break;
                case "size" :
                    sb.append(size()).append('\n');
                    break;
                case "empty" :
                    sb.append(empty()).append('\n');
                    break;
                case "top" :
                    sb.append(top()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}