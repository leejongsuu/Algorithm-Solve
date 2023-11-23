// 예시 입력
/*
10 3
13 15 34 23 45 65 33 11 26 42
*/

// 예시 출력 143

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

class Main {
	
	public int solution(int a, int b, int[] arr){
		
		int answer = -1;
		TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
		
		for(int i=0; i<a; i++)
			for(int j=i+1; j<a; j++)
				for(int k= j+1; k<a; k++)
					ts.add(arr[i]+arr[j]+arr[k]);
		int cnt =0;
		for(int i : ts) {
			cnt++;
			if(cnt==b) return i;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] arr = new int[a];
		
		for(int i=0; i<a; i++)
			arr[i]=sc.nextInt();
		
		System.out.println(T.solution(a, b, arr));
	}
}
