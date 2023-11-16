// 예시 입력 20
// 예시 출력 8

import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();

		for(int i=2; i<n; i++) {
			if(arr[i]==0)
			{
				answer.add(i);
				for(int j=2; i*j<n; j++)
					arr[i*j]=1;
			}
		}
		
		return answer;
	}	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt()+1;
		int[] arr = new int[n];
		
		System.out.println(T.solution(n, arr).size());
	}
}
