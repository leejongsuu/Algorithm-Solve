import java.util.Scanner;

public class Main {

    public char[] solution(int n, int[] a, int[] b) {

        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            int result = a[i] - b[i];
            switch (result) {
                case -2 : ch[i] = 'A'; break;
                case -1 : ch[i] = 'B'; break;
                case 0 : ch[i] = 'D'; break;
                case 1 : ch[i] = 'A'; break;
                case 2 : ch[i] ='B'; break;
            }
        }

        return ch;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        for (char c : T.solution(n, a, b)) {
            System.out.println(c);
        }
    }
}
