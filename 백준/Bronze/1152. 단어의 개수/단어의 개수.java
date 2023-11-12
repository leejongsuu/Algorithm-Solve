import java.util.Scanner;
import java.util.Arrays;
class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String str= sc.nextLine();
		int a = 1;
		if(str.length()==1 && str.charAt(0)==' ')
		{
			System.out.println(0);
			return;
		}
		
		str= str.trim();
		
		for(int i =0; i<str.length(); i++)
		{
			if(str.charAt(i)==' ')
			{
				a++;
			}
		}
		System.out.println(a);
	}
}