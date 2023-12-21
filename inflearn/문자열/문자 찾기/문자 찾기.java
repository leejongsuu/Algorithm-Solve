//예시 입력 
/*
Computercooler
c
*/

//예시 출력 2

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        char c = sc.next().toLowerCase().charAt(0);

        int cnt =0;
        for (char ch : str.toCharArray())
            if(ch==c) cnt++;

        System.out.println(cnt);
    }
}
