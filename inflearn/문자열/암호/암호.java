### 풀이 1
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		String answer="";
		int sum=0;
		
		for(int i=0; i<n; i++)
		{
			for(int j=0;j<7;j++)
				if(str.charAt(j)=='#')
					sum+=Math.pow(2, 6-j);
			answer+=(char)sum;
			sum=0;
			str=str.substring(7);
		}
		System.out.println(answer);
	}
}

###풀이 2
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next().replace('#','1').replace('*','0');
		String answer="";
		for(int i=0; i<n; i++)
		{
			String tmp=str.substring(0,7);
			int num = Integer.parseInt(tmp, 2);
			answer+=(char)num;
			str=str.substring(7);
		}
		System.out.println(answer);
	}
}
