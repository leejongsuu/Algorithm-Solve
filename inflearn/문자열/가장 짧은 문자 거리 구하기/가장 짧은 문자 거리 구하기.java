//예시 입력 teachermode e
//예시 출력 1 0 1 2 1 0 1 2 2 1 0

import java.util.Scanner;

public class Main {

    public int[] solution(String str, char c){

        int[] answer = new int[str.length()];

        int p = 101;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==c) p = 0;
            else p++;
            answer[i] = p;
        }

        for (int i = str.length()-1; i >=0; i--) {
            if(str.charAt(i)==c) p = 0;
            else p++;
            answer[i] = Math.min(answer[i], p);
        }

        return answer;
    }



    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);

        for (int x : T.solution(str, c)) {
            System.out.print(x+" ");
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        String s = parts[0];
        char t = parts[1].charAt(0);

        int[] distance = getDistance(s, t);
        StringBuilder sb = new StringBuilder();
        for (int d : distance) {
            sb.append(d).append(' ');
        }

        System.out.println(sb);

    }

    public static int[] getDistance(String s, char t) {
        int len = s.length();
        int[] distance = new int[len];

        int d = 101;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == t) {
                d = 0;
            } else {
                d++;
            }
            distance[i] = d;
        }

        d = 101;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                d = 0;
            } else {
                d++;
            }
            distance[i] = Math.min(d, distance[i]);
        }

        return distance;
    }
}
