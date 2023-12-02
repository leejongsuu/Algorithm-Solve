import java.util.Scanner;

public class Main {

    public int DFS(int n) {

        if(n==1) return 1;
        else if(n==2) return 1;
        else return DFS(n - 2) + DFS(n - 1);

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++)
            System.out.print(T.DFS(i)+" ");
    }
}
