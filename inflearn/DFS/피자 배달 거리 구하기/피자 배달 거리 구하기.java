//예시 입력
/*
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
*/

//예시 출력 6

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pizza, home;

    public int searchMin(int[] combi) {

        int sum = 0;
        for (Point h : home) {
            int min = Integer.MAX_VALUE;
            for (int x : combi) {
                Point p = pizza.get(x);
                min = Math.min(min, Math.abs(h.x - p.x) + Math.abs(h.y - p.y));
            }
            sum += min;
        }
        return sum;
    }

    public void DFS(int L, int s) {

        if(L==m) answer = Math.min(answer, searchMin(combi));
        else {
            for (int i =s; i<len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        pizza = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                int data = sc.nextInt();
                if(data==1) home.add(new Point(i, j));
                else if(data==2) pizza.add(new Point(i, j));
            }

        len = pizza.size();

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
