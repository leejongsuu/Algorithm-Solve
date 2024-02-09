import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void push(int x) {
        list.add(x);
    }

    public static int pop() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.remove(list.size() - 1);
        }
    }
    
    public static int size() {
        return list.size();
    }
    
    public static int empty() {
        if (list.isEmpty()) {
            return 1;
        } else {
            return 0;
        } 
    }
    
    public static int top() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.get(list.size() - 1);
        } 
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                push(Integer.parseInt(input[1]));
            } else if (input[0].equals("top")) {
                sb.append(top()).append('\n');
            } else if (input[0].equals("size")) {
                sb.append(size()).append('\n');
            } else if (input[0].equals("pop")) {
                sb.append(pop()).append('\n');
            } else if (input[0].equals("empty")) {
                sb.append(empty()).append('\n');
            }
        }

        System.out.println(sb);
    }
}