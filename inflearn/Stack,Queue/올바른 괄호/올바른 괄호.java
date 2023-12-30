// 예시 입력 (()(()))(()
// 예시 출력 No

import java.util.Scanner;
import java.util.Stack;

public class Main {


    public String solution(String str) {

        String answer = "NO";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if(c=='(') stack.push('(');
            else if(stack.isEmpty()) return "NO";
            else stack.pop();
        }

        if(stack.empty()) return "YES";

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
