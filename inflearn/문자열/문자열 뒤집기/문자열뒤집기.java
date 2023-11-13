import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String temp = sc.nextLine();
		for(int i=0; i<n; i++)
		{
			String str = sc.nextLine();
			str= new StringBuffer(str).reverse().toString();
			System.out.println(str);
		}
	}
}
