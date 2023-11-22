//예시 입력
/* AbaAeCe
baeeACA
*/

//예시 출력 YES

import java.util.HashMap;
import java.util.Scanner;

class Main {
	
	public void solution(String Astr, String Bstr){
		
		HashMap<Character,Integer> Amap = new HashMap<>();
		HashMap<Character,Integer> Bmap = new HashMap<>();
		
		for(char c : Astr.toCharArray())
			Amap.put(c, Amap.getOrDefault(c,0)+1);
		for(char c : Bstr.toCharArray())
			Bmap.put(c, Bmap.getOrDefault(c,0)+1);
		
		if(Amap.equals(Bmap))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String Astr = sc.next();
		String Bstr = sc.next();
		
		T.solution(Astr, Bstr);
	}
}
