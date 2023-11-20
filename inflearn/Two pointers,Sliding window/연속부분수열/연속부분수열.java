//예시 입력
/*
8 6
1 2 1 3 1 1 1 2
*/

//예시 출력 3

import java.util.Scanner;

class Main {
	
	public int solution(int n, int m, int[] arr){
		
		int answer = 0;
		
		int lt=0,sum=0;
		for(int rt=0; rt<n; rt++) {
			sum+=arr[rt];
			if(sum==m) answer++;
			while(sum>=m) {
				sum-=arr[lt++];
				if(sum==m) answer++;
			}
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
