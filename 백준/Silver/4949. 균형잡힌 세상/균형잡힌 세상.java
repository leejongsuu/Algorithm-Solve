import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static boolean solution(String str) {

        boolean check = true;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c=='(' || c=='[') stack.add(c);
            else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    check = false;
                    break;
                }
            }
            else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    check = false;
                    break;
                }
            }
        }
        
        if (!stack.isEmpty()) check = false;
        
        return check;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String str;

        while (true) {
            str = br.readLine();
            if (str.length() == 1 || str.charAt(0) == '.') break;

            if (solution(str)) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);
    }
}