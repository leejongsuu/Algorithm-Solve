import java.util.Scanner;

public class Main {

    public String solution(int n, String str){

        String answer = "";

        for (int i = 0; i < n; i++) {
            String temp = str.substring(0, 7);
            answer += (char) Integer.parseInt(temp, 2);
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next().replace('#','1').replace('*','0');

        System.out.println(T.solution(n, str));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine().replace("#", "1").replace("*", "0");
        
        String[] secretes = new String[N];
        for (int i = 0; i < N; i++) {
            int index = i * 7;
            secretes[i] = str.substring(index, index + 7);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append((char) Integer.parseInt(secretes[i], 2));
        }

        System.out.println(sb);
    }
}
