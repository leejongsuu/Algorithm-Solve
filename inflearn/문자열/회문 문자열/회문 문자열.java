//예시 입력 gooG
//예시 출력 YES
import java.util.Scanner;

public class Main {

    public String solution(String str){

        String answer = "NO";

        if(str.equals(new StringBuffer(str).reverse().toString()))
            answer = "YES";

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();

        System.out.println(T.solution(str));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase();

        if (str.contentEquals(new StringBuffer(str).reverse())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
