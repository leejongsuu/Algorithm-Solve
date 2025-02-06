import java.util.Scanner;

public class Main {

    public String solution(String str){
        String answer = "";

        for (int i = 0; i < str.length(); i++)
            if(i==str.indexOf(str.charAt(i))) answer += str.charAt(i);

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        boolean[] alphabet = new boolean[26];
        for (char c : str.toCharArray()) {
            if (!alphabet[c - 'a']) {
                alphabet[c - 'a'] = true;
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}

