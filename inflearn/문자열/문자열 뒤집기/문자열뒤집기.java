//예시 입력
/*
3
good
Time
Big
*/
//예시 출력
/*
doog
emiT
giB
*/
import java.util.Scanner;

public class Main {

    static int n;
    static String[] strArr;

    public void  solution(){

        for (int i=0; i< strArr.length; i++)
            strArr[i] = new StringBuffer(strArr[i]).reverse().toString();
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        strArr = new String[n];

        for (int i = 0; i < n; i++) strArr[i] = sc.next();
        T.solution();
        for(String str : strArr) System.out.println(str);

    }
}
