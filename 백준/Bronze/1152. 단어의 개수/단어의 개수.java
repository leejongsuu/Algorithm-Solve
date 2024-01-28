import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        if (str.isEmpty()) {
            System.out.println(0);
        } else {

            int cnt = 1;
            for (char c : str.toCharArray()) {
                if (c == ' ') {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
