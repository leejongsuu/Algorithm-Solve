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
