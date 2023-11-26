// 예시 입력
/*
1. 5 2
    60 50 70 80 90 

2. 6 3
70 60 90 60 60 60
*/

// 예시 출력 1. 3 , 2. 4

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
	int id;
	int priority;
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}

class Main {
	
	public int solution(int m, int[] arr){
		
		int answer = 0;
		Queue<Person> queue = new LinkedList<>();
		for(int i=0; i<arr.length; i++)
			queue.add(new Person(i, arr[i]));
		
		while(!queue.isEmpty()) {
			Person tmp = queue.poll();
			for(Person p : queue) {
				if(p.priority>tmp.priority) {
					queue.add(tmp);
					tmp=null;
					break;
				}
			}
			if(tmp!=null) {
				answer++;
				if(tmp.id == m)
					return answer;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(T.solution(m, arr));
	}
}
