// 예시 입력 9     32 55 62 20 250 370 200 30 100

// 예시 출력 23 2 73 2 3

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

     //소수 판별
    public boolean number(int num) {

        if(num==1) return false;
        for (int i = 2; i < num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, String[] str) {

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String reStr = new StringBuffer(str[i]).reverse().toString();
            int x = Integer.parseInt(reStr);
            if(number(x)) answer.add(x);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) str[i] = sc.next();

        for(int x : T.solution(n, str)) System.out.print(x + " ");

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int INF = 100001;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[] flag = new boolean[INF];
        flag[0] = flag[1] = true;
        for (int i = 2; i < INF; i++) {
            if (!flag[i]) {
                for (int j = 2; i * j < INF; j++) {
                    flag[i * j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = reverse(st.nextToken());
            if (!flag[num]) {
                sb.append(num).append(' ');
            }
        }

        System.out.println(sb);
    }

    public static int reverse(String sNum) {
        return Integer.parseInt(new StringBuffer(sNum).reverse().toString());
    }
}

