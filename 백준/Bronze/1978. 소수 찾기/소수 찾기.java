import java.util.Scanner;

public class Main {

    public boolean solution(int num) {

        if(num<2) return false;
        else {
            for (int i = 2; i < num; i++) {
                if(num%i==0) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (T.solution(tmp)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
