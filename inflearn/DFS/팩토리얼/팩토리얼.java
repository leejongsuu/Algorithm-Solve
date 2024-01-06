//예시 입력 5
//예시 출력 120

import java.util.Scanner;

public class Main {

    public int DFS(int v) {
        if (v == 1) return v;
        else return v * DFS(v - 1);
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.DFS(n));
    }
}
