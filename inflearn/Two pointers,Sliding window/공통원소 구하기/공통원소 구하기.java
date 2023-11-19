//예시 입력
/*
5
1 3 9 5 2
5
3 2 5 7 8
*/

//예시 출력 2 3 5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		
		int p1=0,p2=0;
		
		while(p1<n && p2<m) {
			if(a[p1]<b[p2]) p1++;
			else if (a[p1]>b[p2]) p2++;
			else {
				answer.add(a[p1]);
				p1++;
				p2++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i]=sc.nextInt();
		
		int m = sc.nextInt();
		int[] b = new int[m];
		for(int i=0; i<m; i++)
			b[i]=sc.nextInt();
		
		for(int i : T.solution(n, m, a, b))
			System.out.print(i+" ");
	}
}
