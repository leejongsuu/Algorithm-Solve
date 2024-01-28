import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a==0 || b==0 ||c==0) break;
            list.add(a);
            list.add(b);
            list.add(c);
            list.sort(Comparator.reverseOrder());

            a = list.get(0);
            b = list.get(1);
            c = list.get(2);
            if (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
            list.clear();
        }
    }
}
