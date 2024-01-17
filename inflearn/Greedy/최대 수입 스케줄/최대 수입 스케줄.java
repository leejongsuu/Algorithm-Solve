//예시 입력 
/*
6
50 2
20 1
40 2
60 3
30 3
30 1
*/
//예시 출력 150

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Schedule implements Comparable<Schedule> {

    int money, day;

    public Schedule(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Schedule o) {
        return o.day - this.day;
    }
}

public class Main {

    public int solution(int n, int max, ArrayList<Schedule> list) {

        int answer = 0;
        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if(list.get(j).day<i) break;
                pQ.offer(list.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = Integer.MAX_VALUE;
        ArrayList<Schedule> list = new ArrayList<>(5);

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Schedule(m, d));
            if (d > max) max = d;
        }

        System.out.println(T.solution(n, max, list));
    }
}
