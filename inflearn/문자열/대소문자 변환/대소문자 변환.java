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
