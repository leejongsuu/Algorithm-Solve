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

class brick implements Comparable<brick> {
    int st, ht, wt;

    public brick(int st, int ht, int wt) {
        this.st = st;
        this.ht = ht;
        this.wt = wt;
    }

    @Override
    public int compareTo(brick o) {
        return o.st - this.st;
    }
}

public class Main {

    static int n;
    static int[] di;
    static ArrayList<brick> list = new ArrayList<>();

    public int solution() {

        Collections.sort(list);
        di[0] = list.get(0).ht;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).wt>list.get(i).wt && di[j]>max) max = di[j];
            }
            di[i] = max + list.get(i).ht;
        }

        return Arrays.stream(di).max().getAsInt();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        di = new int[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new brick(s, h, w));
        }

        System.out.println(T.solution());
    }
}
