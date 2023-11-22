//예시 입력
/*
7 4
20 12 20 10 23 17 10
  */

//예시 출력 3 4 4 3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
	
	public ArrayList<Integer> solution(int n,int m, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<m-1; i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		int lt=0;
		for(int rt=m-1; rt<n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			answer.add(map.size());
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt])==0)
				map.remove(arr[lt]);
			lt++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();
		
		for(int i : T.solution(n, m, arr))
			System.out.print(i+ " ");
	}
}
