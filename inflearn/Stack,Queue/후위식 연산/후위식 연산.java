//예시 입력 352+*9-
//예시 출력 4
import java.util.Scanner;
import java.util.Stack;

class Main {
	
	public int solution(String str){
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) stack.push(c-48);
			else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(c=='+') stack.push(lt+rt);
				else if(c=='-') stack.push(lt-rt);
				else if(c=='*') stack.push(lt*rt);
				else if(c=='/') stack.push(lt/rt);
			}
		}
		answer=stack.get(0);
		return answer;
	}
	
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(T.solution(str));
	}
}
