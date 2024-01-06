//예시 입력 3
//예시 출력 1 2 3
import java.util.Scanner;

public class Main {

    public void DFS(int v) {

        if(v==0) return;
        else {
            DFS(v - 1);
            System.out.print(v+" ");
        }
    }
    
    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.DFS(n);
    }
}
