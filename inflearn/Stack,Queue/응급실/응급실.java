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



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Patient {
        int order;
        int risk;

        public Patient(int order, int risk) {
            this.order = order;
            this.risk = risk;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Patient(i, Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; !queue.isEmpty(); ) {
            Patient current = queue.poll();

            boolean flag = false;
            for (Patient pa : queue) {
                if (current.risk < pa.risk) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                queue.offer(current);
            } else {
                if (current.order == M) {
                    System.out.println(i);
                    break;
                }
                i++;
            }
        }
    }
}
