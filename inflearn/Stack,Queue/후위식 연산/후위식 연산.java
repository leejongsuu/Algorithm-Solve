//예시 입력 352+*9-
//예시 출력 4
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public int solution(String str) {

        int answer;
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                switch (c){
                    case '+' : stack.push(lt+ rt); break;

                    case '*' : stack.push(lt * rt); break;

                    case '/' :  stack.push(lt / rt); break;

                    case '-' :  stack.push(lt - rt); break;
                }
            }
        }
        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
