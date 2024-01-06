//예시 입력 11
//예시 출력 1011
import java.util.Scanner;

public class Main {

    public void DFS(int v) {

        if(v==1) System.out.print(v);
        else {
            DFS(v / 2);
            System.out.print(v % 2);
        }
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.DFS(n);
    }
}
