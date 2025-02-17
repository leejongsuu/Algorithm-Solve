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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (list.contains(num)) {
                list.remove((Integer) num);
            } else if (list.size() >= S) {
                list.remove(S - 1);
            }
            list.add(0, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
