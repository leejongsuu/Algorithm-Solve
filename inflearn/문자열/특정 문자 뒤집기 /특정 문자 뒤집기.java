import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] s = str.toCharArray();
		int lt =0, rt= str.length()-1;
		while(lt<rt) {
			if(!Character.isAlphabetic(s[lt]))
				lt++;
			else if(!Character.isAlphabetic(s[rt]))
				rt--;
			else
			{
				char temp=s[lt];
				s[lt]=s[rt];
				s[rt]=temp;
				lt++;
				rt--;
			}
		}
		for(char ch : s)
			System.out.print(ch);
	}
}
