//예시 입력
/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2
*/
// 예시 출력 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int s,h, w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}

public class Main {

    static int[] dy;
    static ArrayList<Brick> list;

    public int solution(int n) {

        Collections.sort(list);
        dy[0] = list.get(0).h;
        for (int i = 1; i < n; i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(list.get(i).w<list.get(j).w && dy[j]>max_h) max_h = dy[j];
            }
            dy[i] = list.get(i).h + max_h;
        }
        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Brick(a, b, c));
        }
        System.out.println(T.solution(n));
    }
}
