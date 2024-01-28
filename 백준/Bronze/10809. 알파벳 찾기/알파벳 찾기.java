import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String str = sc.next();

        for (char c : alphabet.toCharArray()) {
            System.out.print(str.indexOf(c)+" ");
        }
    }
}
