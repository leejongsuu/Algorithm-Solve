// 예시 입력 8 3
// 예시 출력 7

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

  // 풀이 1 큐 이용
	public int solution(int n, int k){
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<n+1; i++)
			queue.offer(i);
		
		while(queue.size()!=1) {
			int i = 1;
			while(i<k) {
				queue.offer(queue.poll());
				i++;
			}
			queue.poll();
		}
		answer=queue.poll();
		return answer;
	}

  //풀이 2 스택 이용
  public int solution2(int n, int k){
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=1; i<n+1; i++)
			stack.push(i);
		
		int x = k-1;
		while(stack.size()!=1) {
			stack.remove(x);
			x+=k-1;
			while(x>=stack.size()) x-=stack.size();
		}
		answer = stack.get(0);
		
		return answer;
	}
  
	
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(T.solution(n,k));
	}
}


