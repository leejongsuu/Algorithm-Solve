import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next().toUpperCase();
        int[] alphabet = new int[26];

        int max = 0;
        int location = 0;
        boolean check = false;
        for (char c : str.toCharArray()) {
            int i = c - 'A';
            alphabet[i]++;
            if (alphabet[i] > max) {
                max = alphabet[i];
                location = i;
                check = false;
            } else if (alphabet[i] == max) {
                check = true;
            }
        }
        System.out.println(check ? "?" : (char) (location + 'A'));
    }
}
