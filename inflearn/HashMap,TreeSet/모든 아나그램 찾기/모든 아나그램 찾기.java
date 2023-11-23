//예시 입력
/*
bacaAacba
abc
*/

//예시 출력 3

import java.util.HashMap;
import java.util.Scanner;

class Main {
	
	public int solution(String aStr, String bStr){
		int answer = 0;
		HashMap<Character,Integer> aMap = new HashMap<>();
		HashMap<Character,Integer> bMap = new HashMap<>();
		
		for(int i=0; i<bStr.length()-1; i++)
			aMap.put(aStr.charAt(i), aMap.getOrDefault(aStr.charAt(i), 0)+1);
		for(int i=0; i<bStr.length(); i++)
			bMap.put(bStr.charAt(i), bMap.getOrDefault(bStr.charAt(i), 0)+1);
		
		int lt = 0;
		for(int rt=bStr.length()-1; rt<aStr.length(); rt++) {
			aMap.put(aStr.charAt(rt), aMap.getOrDefault(aStr.charAt(rt), 0)+1);
			if(aMap.equals(bMap))
				answer++;
			if(aMap.get(aStr.charAt(lt))==1)
				aMap.remove(aStr.charAt(lt));
			else {
				aMap.put(aStr.charAt(lt), aMap.get(aStr.charAt(lt))-1);
			}
			lt++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String aStr = sc.nextLine();
		String bStr = sc.nextLine();

		System.out.println(T.solution(aStr, bStr));
	}
}
