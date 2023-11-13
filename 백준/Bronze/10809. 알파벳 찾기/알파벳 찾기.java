import java.util.Scanner;
import java.util.Arrays;
class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String lang = "abcdefghijklmnopqrstuvwxyz";
		for(int i=0;i<lang.length();i++)
		{
			System.out.print(str.indexOf(lang.charAt(i))+" ");
		}	
	}
}