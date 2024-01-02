// 예시 입력
/*
5 9
1 2 3 2 6 2 3 5 7
*/

// 예시 출력 7 5 3 2 6

//풀이 1 
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        int[] answer = new int[n];
        for (int i : arr) {

            int pos = -1;
            for (int j = 0; j < n; j++) if(answer[j] == i) pos = j;

            if (pos == -1)
                for (int j = n - 1; j > 0; j--) answer[j] = answer[j - 1];
            else
                for (int j = pos; j > 0; j--) answer[j] = answer[j - 1];

            answer[0] = i;
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = sc.nextInt();

        for(int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}

//풀이 2
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Integer> solution(int n, int m, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>(n);

        for(int i : arr){
            if(answer.contains(i)) answer.remove(answer.indexOf(i));
            if(answer.size()==n) answer.remove(n - 1);
            answer.add(0, i);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = sc.nextInt();

        for(int x : T.solution(n, m, arr)) System.out.print(x + " ");

    }
}
