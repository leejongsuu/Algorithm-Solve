//예시 입력
/*
5
172 67
183 65
180 70
170 72
181 60
*/

//예시 출력 3


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class body implements Comparable<body>{
    int ht, wt;

    public body(int ht, int wt) {
        this.ht = ht;
        this.wt = wt;
    }

    @Override
    public int compareTo(body o) {
        return o.ht - this.ht;
    }
}

public class Main {

    static int n;
    static ArrayList<body> player;

    public int Greedy() {

        int answer = 0;
        Collections.sort(player);
        int wtMax = Integer.MIN_VALUE;

        for(body b : player)
            if(b.wt>wtMax){
                wtMax = b.wt;
                answer++;
            }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        player = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            player.add(new body(height, weight));
        }
        System.out.println(T.Greedy());
    }
}
