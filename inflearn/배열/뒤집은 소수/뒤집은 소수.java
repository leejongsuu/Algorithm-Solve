// 예시 입력 9     32 55 62 20 250 370 200 30 100

// 예시 출력 23 2 73 2 3

import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
//소수 판별 
	public boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2; i<num; i++) 
			if(num%i==0)
				return false;
		return true;
	}
	
//자연수 뒤집
	public ArrayList<Integer> solution(int n, String[] str){
		ArrayList<Integer> answer = new ArrayList<>();
        int[] arr = new int[n];
        
		for(int i=0; i<n; i++) {
			String rev = new StringBuffer(str[i]).reverse().toString();
			arr[i]=Integer.parseInt(rev);
			if(isPrime(arr[i])) answer.add(arr[i]);
		}	
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		String[] str = new String[n];
		
		for(int i=0; i<n;) {
			String tmp = sc.next();
			if(tmp.charAt(0)!='0') {
				str[i]=tmp;
				i++;
			}
		}
		
		for(int result : T.solution(n, str))
			System.out.print(result+" ");
	}
}
