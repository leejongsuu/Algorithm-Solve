//예시 입력
/*
5
1 3 9 5 2
5
3 2 5 7 8
*/

//예시 출력 2 3 5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public ArrayList<Integer> solution(int[] a, int[] b) {

        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a); Arrays.sort(b);

        int lt = 0, rt = 0;
        while (lt < a.length && rt < b.length) {
            if(a[lt]<b[rt]) lt++;
            else if(a[lt]>b[rt]) rt++;
            else {
                answer.add(a[lt]);
                lt++;
                rt++;
            }
        }

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
