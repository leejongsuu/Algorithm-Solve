//예시 입력 15 BACBACCACCBDEDE
//예시 출력 C


import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Character, Integer> map;

    public char solution(int n, String str) {

        char answer=' ';

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            char c = str.charAt(i);
            int x = map.getOrDefault(str.charAt(i), 0) + 1;
            if (x > max) {
                max = x;
                answer = c;
            }
            map.put(c, x);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        map = new HashMap<>(5);

        System.out.println(T.solution(n, str));
    }
}
