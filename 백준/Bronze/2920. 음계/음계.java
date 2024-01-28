import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String answer = "mixed";

        if (n == 1) {
            answer = "ascending";
            for (int i = 2; i <= 8; i++) {
                if (i != sc.nextInt()) {
                    answer = "mixed";
                    break;
                }
            }
        } else if (n == 8) {
            answer = "descending";
            for (int i = 7; i >0 ; i--) {
                if (i != sc.nextInt()) {
                    answer = "mixed";
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
