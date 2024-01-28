import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a * b * c;
        int[] arr = new int[10];

        for (char ch : String.valueOf(sum).toCharArray()) {
            arr[ch - '0']++;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
