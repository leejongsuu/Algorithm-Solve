// 예시 입력
/*
8
20 25 52 30 39 33 43 33
*/

//예시 출력 D

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (list.contains(x)) {
                System.out.println("D");
                return;
            }
            list.add(x);
        }

        System.out.println("U");
    }
}
