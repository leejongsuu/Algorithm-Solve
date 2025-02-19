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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Athlete implements Comparable<Athlete> {
        int height, weight;

        public Athlete(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Athlete o) {
            if (o.height == this.height) return o.weight - this.weight;
            else return o.height - this.height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Athlete> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Athlete(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int result = 0, maxWeight = 0;
        for (Athlete a : list) {
            if (a.weight > maxWeight) {
                maxWeight = a.weight;
                result++;
            }
        }

        System.out.println(result);
    }
}
