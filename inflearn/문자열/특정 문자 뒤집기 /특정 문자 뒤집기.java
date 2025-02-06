import java.util.Scanner;

public class Main {

    public char[] solution(String str){

        char[] ch = str.toCharArray();
        int rt = str.length()-1;
        for (int lt = 0; lt < rt; lt++) {
            if (Character.isAlphabetic(ch[lt])) {
                while (!Character.isAlphabetic(ch[rt])) {
                    rt--;
                }
                char tmp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = tmp;
                rt--;
            }
        }
        return ch;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for(char c : T.solution(str))
            System.out.print(c);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        int lt = 0;
        int rt = ch.length - 1;

        while (lt < rt) {
            while (!Character.isAlphabetic(ch[lt])) lt++;
            while (!Character.isAlphabetic(ch[rt])) rt--;
            char temp = ch[lt];
            ch[lt] = ch[rt];
            ch[rt] = temp;
            lt++;
            rt--;
        }

        System.out.println(ch);
    }
}
