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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        while (st.hasMoreTokens()) {
            if (!set.add(Integer.parseInt(st.nextToken()))) {
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");
    }
}
