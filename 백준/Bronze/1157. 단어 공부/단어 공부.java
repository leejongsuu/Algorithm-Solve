import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next().toUpperCase();
        int[] alphabet = new int[26];

        int max = 0;
        char ch = '?';
        for (char c : str.toCharArray()) {
            int i = c - 'A';
            alphabet[i]++;
            if (alphabet[i] > max) {
                max = alphabet[i];
                ch = c;
            } else if (alphabet[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
