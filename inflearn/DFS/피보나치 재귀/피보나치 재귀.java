//예시 입력 10
//예시 출력 1 1 2 3 5 8 13 21 34 55
import java.util.Scanner;

public class Main {

    public int DFS(int v) {

        if(v==1) return 1;
        else if(v==2) return 1;
        else return DFS(v - 1) + DFS(v - 2);
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) System.out.print(T.DFS(i) + " ");
    }
}
