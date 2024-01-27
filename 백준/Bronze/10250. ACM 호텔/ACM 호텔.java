import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            boolean check = false;
            String answer = "";
            
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            for (int j = 1; j <= w; j++) {
                if (check) break;
                for (int k = 1; k <= h; k++) {
                    n--;
                    if (n==0) {
                        check = true;
                        answer += String.valueOf(k);
                        answer += j < 10 ? ("0" + String.valueOf(j)) : String.valueOf(j);
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
