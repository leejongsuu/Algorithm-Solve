//예시 입력
/*
5
172 67
183 65
180 70
170 72
181 60
*/

//예시 출력 3

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person> {
    int h, w;

    public Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person o) {
        if (o.h == this.h) return o.w - this.w;
        else return o.h - this.h;
    }
}

public class Main {

    public int solution(ArrayList<Person> list) {

        int answer = 0;
        Collections.sort(list);

        int min = Integer.MIN_VALUE;
        for (Person p : list) {
            if (p.w > min) {
                answer++;
                min = p.w;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Person(height, weight));
        }

        System.out.println(T.solution(list));
    }
}
