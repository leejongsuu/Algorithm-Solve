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
