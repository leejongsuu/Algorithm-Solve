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
        for(char c : require.toCharArray()) Q.offer(c);

        for (char c : str.toCharArray())
            if (Q.contains(c) && c!=Q.poll()) return "NO";

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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String required = br.readLine();
        String plan = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        for (char c : required.toCharArray()) queue.offer(c);

        for (char c : plan.toCharArray()) {
            if (queue.contains(c) && queue.poll() != c) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(queue.isEmpty() ? "YES" : "NO");
    }
}

