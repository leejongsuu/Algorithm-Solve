//예시 입력 
/*
Computercooler
c
*/

//예시 출력 2

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase();
        char target = Character.toLowerCase(br.readLine().charAt(0));

        int answer = 0;
        for (char ch : str.toCharArray()) {
            if (ch == target) answer++;
        }

        System.out.println(answer);
    }
}

