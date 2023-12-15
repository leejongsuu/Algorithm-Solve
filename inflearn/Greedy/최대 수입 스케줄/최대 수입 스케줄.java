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

class Order implements Comparable<Order>{
    int money, day;

    public Order(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Order o) {
        return o.day - this.day;
    }
}


public class Main {

    static int n, max = Integer.MIN_VALUE;
    static ArrayList<Order> schedule;

    public int Greedy() {

        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(schedule);

        int j=0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if(schedule.get(j).day<i) break;
                pQ.offer(schedule.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        schedule = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            schedule.add(new Order(m, d));
            if(d>max) max = d;
        }
        System.out.println(T.Greedy());
    }
}
