//예시 입력
/*
CBA
CBDAGE
*/

//예시 출력 YES

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public String solution(String require, String str) {

        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char c : require.toCharArray()) Q.add(c);

        for (char c : str.toCharArray()) {
            if (Q.contains(c)) {
                if(c!=Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";


        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String require = sc.next();
        String str = sc.next();

        System.out.println(T.solution(require, str));
    }
}
