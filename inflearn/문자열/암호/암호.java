import java.util.Scanner;

public class Main {

    public String solution(int n, String str){

        String answer = "";

        for (int i = 0; i < n; i++) {
            String temp = str.substring(0, 7);
            answer += (char) Integer.parseInt(temp, 2);
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next().replace('#','1').replace('*','0');

        System.out.println(T.solution(n, str));
    }
}
