// 예시 입력 (A(BC)D)EF(G(H)(IJ)K)LM(N)
// 예시 출력 EFLM

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
