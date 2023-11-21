// 예시 입력 15

//예시 출력 3


//풀이 1
import java.util.Scanner;

class Main {
	
	public int solution(int n){
		
		int answer = 0;
		
		int lt=1,sum=0;
		for(int rt =1; rt<n; rt++) {
			sum+=rt;
			if(sum==n)answer++;
			while(sum>=n) {
				sum-=lt++;
				if(sum==n) answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(T.solution(n));
	}
}

//풀이 2
import java.util.Scanner;

class Main {
	
	public int solution(int n){
		
		int answer=0, cnt = 1;
		n--;
		while(n>0) {
			cnt++;
			n=n-cnt;
			if(n%cnt==0) answer++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
			
		System.out.println(T.solution(n));
	}
}
