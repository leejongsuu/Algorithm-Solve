import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String explosion = br.readLine();
        int strLength = str.length();
        int explosionLength = explosion.length();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strLength; i++) {
            stack.push(str.charAt(i));
            int stackSize = stack.size();
            if (stackSize >= explosionLength) {
                boolean flag = true;
                for (int j = 0; j < explosionLength; j++) {
                    if (stack.get(stackSize - explosionLength + j) != explosion.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < explosionLength; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
