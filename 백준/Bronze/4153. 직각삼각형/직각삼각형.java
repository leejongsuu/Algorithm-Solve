import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a==0 || b==0 ||c==0) break;

            if (a > c) {
                int temp = a;
                a = c;
                c = temp;
            }

            if (b > c) {
                int temp = b;
                b = c;
                c = temp;
            }

            if (a * a + b * b == c * c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            } 
        }
    }
}
