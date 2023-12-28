//예시 입력
/* 
AbaAeCe
baeeACA
*/

//예시 출력 YES

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Character, Integer> aMap = new HashMap<>();
    static HashMap<Character, Integer> bMap = new HashMap<>();

    public String solution(String a, String b) {

        String answer = "NO";

        if(a.length()!=b.length()) return "NO";
        for (int i = 0; i < a.length(); i++) {
            aMap.put(a.charAt(i), aMap.getOrDefault(a.charAt(i), 0) + 1);
            bMap.put(b.charAt(i), bMap.getOrDefault(b.charAt(i), 0) + 1);
        }
        if(aMap.equals(bMap)) return "YES";

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(T.solution(a, b));
    }
}
