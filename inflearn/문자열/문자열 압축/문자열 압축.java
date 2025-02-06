import java.util.Scanner;

public class Main {

    public String solution(String str){

        String answer = "";
        int len = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) len++;
            else {
                answer += str.charAt(i);
                if(len>1) answer += String.valueOf(len);
                len = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next()+" ";

        System.out.println(T.solution(str));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine() + "#";

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(str.charAt(i));
                if (count > 1) sb.append(count);
                count = 1;
            }
        }

        System.out.println(sb);

    }
}
