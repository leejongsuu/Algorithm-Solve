import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt() % 42;
            if (!list.contains(n)) {
                cnt++;
                list.add(n);
            }
        }
        System.out.println(cnt);
    }
}
