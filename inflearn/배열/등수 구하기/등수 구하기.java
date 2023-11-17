//예시 입력  5    87 89 92 100 76
//예시 출력 4 3 2 1 5


import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public int[] solution(int n, int[] arr){

		int[] answer = new int[n];
		Arrays.fill(answer, 1);
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++)
				if(arr[i]<arr[j])
					answer[i]++;
		}
		
		for(int i=n-1; i>=0; i--)
			for(int j=i-1; j>=0; j--)
				if(arr[i]<arr[j])
					answer[i]++;
			
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
