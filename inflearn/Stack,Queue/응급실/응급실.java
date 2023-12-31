// 예시 입력
/*
1. 5 2
    60 50 70 80 90 

2. 6 3
70 60 90 60 60 60
*/

// 예시 출력 1. 3 , 2. 4

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int risk, seq;

    public Point(int risk, int seq) {
        this.risk = risk;
        this.seq = seq;
    }
}

public class Main {

    public int solution(int m, Queue<Point> Q) {

        int answer = 0;
        
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            boolean check = true;
            
            for (Point tmp : Q)
                if (tmp.risk > p.risk) {
                    Q.offer(p);
                    check = false;
                    break;
                }
            
            if (check) {
                answer++;
                if(p.seq==m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        Queue<Point> Q = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Q.add(new Point(x, i));
        }

        System.out.println(T.solution(m, Q));
    }
}
