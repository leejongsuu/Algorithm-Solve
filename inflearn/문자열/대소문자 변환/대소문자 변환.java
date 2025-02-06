//예시 입력 StuDY
//예시 출력 sTUdy
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (char c : str.toCharArray()) {
            int x = (int) c;
            if(x>=65 && x<=90) x+=32;
            else if(x>=97 && x<= 122) x-=32;
            System.out.print((char)x);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLowerCase(ch[i])) {
                ch[i] = Character.toUpperCase(ch[i]);
            } else {
                ch[i] = Character.toLowerCase(ch[i]);
            }
        }

        System.out.println(ch);
    }
}
