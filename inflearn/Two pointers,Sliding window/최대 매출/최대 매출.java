// 예시 입력
/*
10 3
12 15 11 20 25 10 20 19 13 15
*/

// 예시 출력 56

import java.util.Scanner;

class Main {
	
	public int solution(int n, int m, int[] arr){
		
		int answer, sum =0;
		
		for(int i=0; i<m; i++)
			sum+=arr[i];
		answer = sum;
		
		for(int i=m; i<=n-m; i++) {
			sum+=arr[i]-arr[i-m];
			answer=Math.max(answer, sum);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int [n];
	
		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();
		
		System.out.println(T.solution(n, m, arr));
	}
}
