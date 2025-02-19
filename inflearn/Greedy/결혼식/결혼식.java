//예시 입력
/*
5
14 18
12 15
15 20
20 30
5 14
*/

//예시 출력 2

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {

    int t;
    Character c;

    public Time(int t, Character c) {
        this.t = t;
        this.c = c;
    }

    @Override
    public int compareTo(Time o) {
        if (this.t == o.t) return this.c.compareTo(o.c);
        else return this.t - o.t;
    }
}

public class Main {

    public int solution(ArrayList<Time> list) {

        int answer = Integer.MIN_VALUE;
        Collections.sort(list);

        int cnt = 0;
        for (Time T : list) {
            if (T.c.equals('s')) {
                cnt++;
                answer = Math.max(answer, cnt);
            } else if (T.c.equals('e')) {
                cnt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>(5);

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Time(start, 's'));
            list.add(new Time(end, 'e'));
        }

        System.out.println(T.solution(list));
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Time implements Comparable<Time> {
        char k;
        int time;

        public Time(char k, int time) {
            this.k = k;
            this.time = time;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) return this.k - o.k;
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Time('s', Integer.parseInt(st.nextToken())));
            list.add(new Time('e', Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int result = 0, count = 0;
        for (Time time : list) {
            if (time.k == 's') {
                count++;
                result = Math.max(result, count);
            } else count--;
        }

        System.out.println(result);
    }
}
