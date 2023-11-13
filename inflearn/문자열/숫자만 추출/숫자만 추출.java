import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str=str.replaceAll("[^0-9]","");
		int i=0;
		while(str.charAt(i)=='0') {		
			i++;
			if(str.charAt(i)!='0')
				str=str.substring(i);
		}
		System.out.println(str);
	}
}
