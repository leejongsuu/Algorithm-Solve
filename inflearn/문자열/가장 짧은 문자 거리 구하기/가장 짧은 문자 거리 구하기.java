//예시 입력 teachermode e
//예시 출력 1 0 12 1 0 1 2 2 1 0

import java.util.Scanner;

public class Main {

    public int[] solution(String str, char c){

        int[] answer = new int[str.length()];

        int p = 101;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==c) p = 0;
            else p++;
            answer[i] = p;
        }

        for (int i = str.length()-1; i >=0; i--) {
            if(str.charAt(i)==c) p = 0;
            else p++;
            answer[i] = Math.min(answer[i], p);
        }

        return answer;
    }



    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);

        for (int x : T.solution(str, c)) {
            System.out.print(x+" ");
        }
    }
}
