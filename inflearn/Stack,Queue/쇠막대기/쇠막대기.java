//예시 입력 ()(((()())(())()))(())
//예시 출력 17

import java.util.Scanner;
import java.util.Stack;

class Main {
	
	public int solution(String str){
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		
		stack.push(str.charAt(0));
		for(int i =1; i<str.length(); i++) {
			if(str.charAt(i)=='(')
				stack.push(str.charAt(i));
			else {
				stack.pop();
				if(str.charAt(i)==str.charAt(i-1)) answer++;
				else answer+=stack.size();
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(T.solution(str));
	}
}
