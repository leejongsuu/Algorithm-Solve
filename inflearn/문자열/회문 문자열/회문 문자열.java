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
