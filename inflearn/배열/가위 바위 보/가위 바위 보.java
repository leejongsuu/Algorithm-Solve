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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] person = new int[2][N];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                person[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(solution(person[0][i], person[1][i])).append('\n');
        }

        System.out.println(sb);
    }

    public static char solution(int a, int b) {
        int c = a - b;
        return switch (c) {
            case -2 -> 'A';
            case -1 -> 'B';
            case 0 -> 'D';
            case 1 -> 'A';
            case 2 -> 'B';
            default -> '0';
        };
    }
}

