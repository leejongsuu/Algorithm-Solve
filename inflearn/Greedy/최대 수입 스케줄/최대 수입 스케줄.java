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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Schedule implements Comparable<Schedule> {
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Schedule> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        int maxDay = list.get(0).day;

        int result = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = maxDay; i > 0; i--) {
            for (; j < N; j++) {
                if (list.get(j).day < i) break;
                priorityQueue.offer(list.get(j).money);
            }
            if (!priorityQueue.isEmpty()) result += priorityQueue.poll();
        }

        System.out.println(result);
    }
}
