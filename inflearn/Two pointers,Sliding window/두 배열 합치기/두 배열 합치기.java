/* 예시 입력
3
1 3 5
5
2 3 6 7 9
*/

// 예시 출력 1 2 3 3 5 6 7 9

// 풀이1
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public int[] solution(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];

        int i;
        for (i = 0; i < a.length; i++) answer[i] = a[i];
        for (int j = 0; j < b.length; j++, i++) answer[i] = b[j];

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        for(int x : T.solution(a,b)) System.out.print(x + " ");
    }
}

//풀이 2
import java.util.Scanner;

public class Main {


    public int[] solution(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];

        int lt = 0, rt = 0, i = 0;

        while (lt < a.length && rt < b.length) {
            if(a[lt]<b[rt]) answer[i++] = a[lt++];
            else answer[i++] = b[rt++];
        }
        while (lt < a.length) answer[i++] = a[lt++];
        while (rt < b.length) answer[i++] = b[rt++];

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        for(int x : T.solution(a,b)) System.out.print(x + " ");
    }
}
