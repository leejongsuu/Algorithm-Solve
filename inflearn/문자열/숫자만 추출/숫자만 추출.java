import java.util.Scanner;

public class Main {

    public String solution(String str){

        str = str.replaceAll("[^0-9]", "");
        while (str.charAt(0) == '0') {
            str = str.substring(1);
        }
        return str;
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

        String str = br.readLine().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(str));
    }
}
