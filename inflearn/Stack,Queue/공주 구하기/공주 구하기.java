// 예시 입력 8 3
// 예시 출력 7

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

// 풀이 1 큐 이용
public int solution(int n, int m) {

        int answer;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.offer(i);

        int cnt = 1;
        while (Q.size() != 1) {
            int x = Q.poll();
            if (cnt == m) cnt = 1;
            else {
                Q.offer(x);
                cnt++;
            }
        }

        answer = Q.poll();
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.offer(i);

        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) queue.offer(queue.poll());
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}

