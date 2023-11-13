
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char ch = sc.next().charAt(0);
		
		int[] len = new int[str.length()];
		int p = 101;
		
		for(int i=0; i< str.length(); i++) {
			if(str.charAt(i)==ch) 
				p=0;
			else
				++p;
			len[i]=p;
		}
		
		for(int i=str.length()-1; i>-1; i--) {
			if(str.charAt(i)==ch)
				p=0;
			else
				++p;
			if(p<len[i])
				len[i]=p;
		}
		for(int n : len)
			System.out.print(n+" ");
	}
}

// import java.util.Scanner;

// class Main {
	
// 	public static void main(String[] args) {
		
// 		Scanner sc = new Scanner(System.in);
		
// 		String str = sc.next();
// 		char ch = sc.next().charAt(0);
		
// 		int[] arr = new int[str.length()];
// 		int len =0;
		
// 		for(int i=0; i<str.length(); i++)
// 		{
// 			if(str.charAt(i)==ch)
// 			{
// 				arr[i]=0;
// 				len++;
// 			}
// 			else
// 				arr[i]=-1;
// 		}
// 		int[] arr2 = new int[len];
// 		for(int i=0,j=0;i< str.length(); i++)
// 		{
// 			if(str.charAt(i)==ch)
// 			{
// 				arr2[j]=i;
// 				j++;
// 			}
// 		}
// 		for(int i=0; i<str.length(); i++)
// 		{
// 			int min = Math.abs(arr2[0]-i);
// 			if(str.charAt(i)!=ch)
// 			{
// 				for(int j=1; j<arr2.length; j++)
// 				{
// 					if((Math.abs(arr2[j]-i))<min)
// 						min=Math.abs(arr2[j]-i);
// 				}
// 				System.out.print(min+" ");
// 			}
// 			else
// 			{
// 				System.out.print(0 + " ");
// 			}
// 		}
// 	}
// }

