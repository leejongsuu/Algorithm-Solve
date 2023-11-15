import java.util.Scanner;

class Main {
	public String solution(int n, int[] a, int[] b){
		String answer="";
		
		for(int i=0; i<n; i++) {
			switch(a[i]-b[i]) {
			case -2 : answer+="A"; break;
			case -1 : answer+="B"; break;
			case 0 : answer+="D"; break;
			case 1 : answer+="A"; break;
			case 2 : answer+="B"; break;
			}
		}
			
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int[] a=  new int[n];
		int[] b = new int[n];
		
		for(int i=0; i<n; i++)
			a[i]=sc.nextInt();
		for(int i=0; i<n; i++)
			b[i]=sc.nextInt();
		
		for(int i=0; i<n; i++)
			System.out.println(T.solution(n,a,b).charAt(i));
	}
}
