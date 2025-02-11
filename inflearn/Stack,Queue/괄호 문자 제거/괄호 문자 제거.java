// 예시 입력 (A(BC)D)EF(G(H)(IJ)K)LM(N)
// 예시 출력 EFLM


//풀이 1
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public String solution(String str) {

        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if(c=='(') stack.push('(');
            else if(c==')') stack.pop();
            else if(stack.isEmpty()) answer += c;
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}

//풀이 2
import java.util.Scanner;
import java.util.Stack;

class Main {
	
	public String solution(String str){
		String answer ="";
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c==')') while(stack.pop()!='(');
			else stack.push(c);
		}
		
		for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
		return answer;
	}
	
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();

		System.out.println(T.solution(str));
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else if (stack.isEmpty()) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
