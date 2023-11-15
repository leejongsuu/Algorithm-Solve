import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		for(int i=0; i<cnt; i++)
			arr[i]=sc.nextInt();
		System.out.print(arr[0]+" ");
		for(int i=1; i<cnt; i++)
			if(arr[i]>arr[i-1])
				System.out.print(arr[i]+" ");
	}
}
