import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public int solution(String a, String b) {

        int answer = 0;

        HashMap<Character, Integer> S = new HashMap<>();
        HashMap<Character, Integer> T = new HashMap<>();

        for (char c : b.toCharArray()) T.put(c, T.getOrDefault(c, 0) + 1);
        int lt = 0, rt;
        for (rt = 0; rt < b.length() - 1; rt++) S.put(a.charAt(rt), S.getOrDefault(a.charAt(rt), 0) + 1);
        for (; rt < a.length(); rt++) {
            S.put(a.charAt(rt), S.getOrDefault(a.charAt(rt), 0) + 1);
            if(S.equals(T)) answer++;
            S.put(a.charAt(lt), S.get(a.charAt(lt)) - 1);
            if(S.get(a.charAt(lt))==0) S.remove(a.charAt(lt));
            lt++;
        }

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
