/* 예시 입력
3
1 3 5
5
2 3 6 7 9
*/

// 예시 출력 1 2 3 3 5 6 7 9

// 풀이1
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	
	public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2){
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			answer.add(arr1[i]);
		for(int i=0; i<m; i++)
			answer.add(arr2[i]);
		Collections.sort(answer);
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++)
			arr1[i]=sc.nextInt();
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++)
			arr2[i]=sc.nextInt();
		
		for(int i : T.solution(n, m, arr1, arr2))
			System.out.print(i+" ");
	}
}

//풀이 2
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		int p1=0,p2=0;
		while(p1<n && p2<m) {
			if(a[p1]<b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}
		while(p1<n) answer.add(a[p1++]);
		while(p2<m) answer.add(b[p2++]);
		
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
