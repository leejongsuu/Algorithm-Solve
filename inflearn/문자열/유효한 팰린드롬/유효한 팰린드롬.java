//예시입력 found7, time: study; Yduts; emit, 7Dnuof
// 예시 출력 YES

import java.util.Scanner;

public class Main {

    public String solution(String str){

        String answer = "YES";
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if(!Character.isAlphabetic(str.charAt(lt))) lt++;
            else if(!Character.isAlphabetic(str.charAt(rt))) rt--;
            else {
                if(str.charAt(lt)!=str.charAt(rt)) return "NO";
                lt++;
                rt--;
            }
        }

        return answer;
    }

    public String solution2(String str){

        String answer = "NO";
        str = str.replaceAll("[^a-z]", "");
        if(str.equals(new StringBuffer(str).reverse().toString())) return "YES";
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();

        System.out.println(T.solution(str));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase().replaceAll("[^a-z]", "");
        if (str.contentEquals(new StringBuilder(str).reverse())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
