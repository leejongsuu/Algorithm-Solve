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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        boolean result = solution(str1, str2);
        System.out.println(result ? "YES" : "NO");
    }

    public static boolean solution(String str1, String str2) {
        Map<Character, Integer> map1 = insertValueMap(str1);
        Map<Character, Integer> map2 = insertValueMap(str2);

        return map1.equals(map2);
    }

    public static Map<Character, Integer> insertValueMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
