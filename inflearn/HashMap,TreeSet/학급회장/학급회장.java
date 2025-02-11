//예시 입력 15 BACBACCACCBDEDE
//예시 출력 C


import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Character, Integer> map;

    public char solution(int n, String str) {

        char answer=' ';

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            char c = str.charAt(i);
            int x = map.getOrDefault(str.charAt(i), 0) + 1;
            if (x > max) {
                max = x;
                answer = c;
            }
            map.put(c, x);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        map = new HashMap<>(5);

        System.out.println(T.solution(n, str));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char result = solution(N, str);
        System.out.println(result);
    }

    public static char solution(int n, String str) {
        int[] candidates = new int[5];
        int max = 0, index = 0;
        for (char c : str.toCharArray()) {
            candidates[c - 'A']++;
            if (candidates[c - 'A'] > max) {
                max = candidates[c - 'A'];
                index = c - 'A';
            }
        }
        return (char) (index + 'A');
    }
}
