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

class time implements Comparable<time> {
    int s, e;

    public time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(time o) {
       if(o.s==this.s) return this.e - o.e;
       else return o.s - this.s;
    }
}

public class Main {

    public int solution(ArrayList<time> list) {

        int answer = 0;
        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        for (time t : list) {
            if (t.e <= min) {
                min = t.s;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<time> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new time(start, end));
        }

        System.out.println(T.solution(list));
    }
}
