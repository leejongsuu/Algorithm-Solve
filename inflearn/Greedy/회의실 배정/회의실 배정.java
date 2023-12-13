//예시 입력 1
/*
5
1 4
2 3
3 5
4 6
5 7
*/

//예시 출력 3

//예시 입력 2
/*
1 3
2 3
3 3
*/

//예시 출력 2

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class time implements Comparable<time>{
    int s, e;

    public time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(time o) {
        if(this.e==o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}

public class Main {

    static int n;
    static ArrayList<time> meeting;

    public int Greedy() {

         int answer = 0;
        Collections.sort(meeting);
        int et = 0;
        for (time t : meeting) {
            if (t.s >= et) {
                answer++;
                et = t.e;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        meeting = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meeting.add(new time(start, end));
        }
        System.out.println(T.Greedy());
    }
}
