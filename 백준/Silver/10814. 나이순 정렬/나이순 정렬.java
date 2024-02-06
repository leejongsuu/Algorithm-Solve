import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Member implements Comparable<Member> {
    int age, key;
    String name;

    public Member(int age, String name, int key) {
        this.age = age;
        this.name = name;
        this.key = key;
    }

    @Override
    public int compareTo(Member o) {
        if (this.age==o.age) return this.key - o.key;
        else return this.age - o.age;
    }

}
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Member> list = new ArrayList<>();
        String[] input;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            list.add(new Member(Integer.parseInt(input[0]), input[1], i));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for (Member member : list) {
            sb.append(member.age).append(' ').append(member.name).append('\n');
        }

        System.out.println(sb);
    }
}