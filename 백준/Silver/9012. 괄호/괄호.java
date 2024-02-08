import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static boolean solution(String str) {

        boolean check = true;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') stack.add(c);
            else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
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

        public static void main (String[]args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            String str;

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                if (solution(str)) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }

            System.out.println(sb);
        }
    }