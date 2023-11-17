//예시 입력  5    87 89 92 100 76
//예시 출력 4 3 2 1 5


import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public int[] solution(int n, int[] arr){

		int[] answer = new int[n];
		
		for(int i=0; i<n; i++) {
			int cnt=1;
			for(int j=0; j<n; j++) {
				if(arr[j]>arr[i]) cnt++;
			}
			answer[i]=cnt;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();

		for(int i : T.solution(n, arr))
			System.out.print(i+" ");
		
	}
}
