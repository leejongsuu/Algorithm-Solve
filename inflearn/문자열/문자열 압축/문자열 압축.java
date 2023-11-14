###풀이 1
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next()+" ";
		String answer="";
		int count = 1;
		for(int i=0; i<str.length()-1; i++)
			if(str.charAt(i)==str.charAt(i+1))
				count++;
			else
			{
				answer+=str.charAt(i);
				if(count>1)
					answer+=String.valueOf(count);
				count=1;
			}
		System.out.println(answer);
	}
}

###풀이2

import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] ch =str.toCharArray();
		for(int i=0; i<ch.length; i++)
		{
			int count =1;
			if(Character.isAlphabetic(ch[i]))
			{
				for(int j=i+1; j<ch.length; j++)
				{
					if(ch[i]==ch[j])
					{
						count++;
						ch[j]='!';
					}
					else
						break;
				}
				System.out.print(ch[i]);
				if(count>1)
					System.out.print(count);
			}
		}
	}
}
