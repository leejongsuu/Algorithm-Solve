// 예시 입력
/* 5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19 */

// 예시 출력 155

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
	
	public int solution(int n, int[][] arr){
		
		ArrayList<Integer> list = new ArrayList<>();
		int answer=0;
		int sum=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				sum+=arr[i][j];
			list.add(sum);
			sum=0;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sum+=arr[j][i];
			}
			list.add(sum);
			sum=0;
		}
		
		for(int i=0; i<n; i++) {
			sum+=arr[i][i];
		}
		list.add(sum);
		sum=0;
		
		for(int i=n-1; i>=0; i--) {
			sum+=arr[i][i];
		}
		list.add(sum);
		
		Collections.sort(list);
		answer = list.get(list.size()-1);
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				arr[i][j]=sc.nextInt();

		System.out.println(T.solution(n, arr));
	}
}
