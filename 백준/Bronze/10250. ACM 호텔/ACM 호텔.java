import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            //계산된 층 수
            int floor = n % h == 0 ? h : n % h;

            //계산된 호 수
            int roomNum = ((n - 1) / h) + 1;

            //출력
            System.out.println(floor * 100 + roomNum);
        }
    }
}
