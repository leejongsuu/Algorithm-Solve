import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public ArrayList<Integer> solution(int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		int max = arr[0];
		
		answer.add(max);
		for(int i=1; i<arr.length; i++)
			if(arr[i]>max)
			{
				max=arr[i];
				answer.add(max);
			}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int len= sc.nextInt();
		int[] arr = new int[len];
		
		for(int i=0; i<len; i++)
			arr[i]=sc.nextInt();
		
		System.out.println(T.solution(arr).size());
	}
}
