import java.util.Scanner;

class Main {
	public int[] solution(int n, int[] arr){
		
		arr[0]=1;
		arr[1]=1;
		for(int i=2; i<n; i++)
			arr[i]=arr[i-1]+arr[i-2];
			
		return arr;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int[] arr = new int[n];
		
		for(int num : T.solution(n, arr) )
			System.out.print(num+" ");
	}
}
