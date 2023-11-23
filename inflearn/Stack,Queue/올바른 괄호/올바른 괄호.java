// 예시 입력 (()(()))(()
// 예시 출력 No

import java.util.Scanner;
import java.util.Stack;

class Main {
	
	public boolean solution(String str){
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c=='(')
				stack.add('(');
			else {
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		if(!stack.isEmpty()) 
			return false;
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		if(T.solution(str))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
