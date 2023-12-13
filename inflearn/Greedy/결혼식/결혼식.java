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

class Order implements Comparable<Order>{
    int t;
    Character c;

    public Order(int t, Character c) {
        this.t = t;
        this.c = c;
    }

    @Override
    public int compareTo(Order o) {
        if(this.t==o.t) return this.c.compareTo(o.c);
        else return this.t - o.t;
    }
}


public class Main {

    static int n;
    static ArrayList<Order> Person;

    public int Greedy() {

        int answer = 0;
        Collections.sort(Person);

        int cnt =0;
        for (Order o : Person) {
            if(o.c.equals('s')){
               cnt++;
               answer = Math.max(answer, cnt);
            } else if(o.c.equals('e')) cnt--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Person = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Person.add(new Order(start,'s'));
            Person.add(new Order(end,'e'));
        }

        System.out.println(T.Greedy());
    }
}
