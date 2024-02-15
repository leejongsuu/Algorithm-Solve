import java.io.*;


public class Main {

    public int solution (String str) {

        //자릿수 길이
        int len = str.length();

        int result = 0;
        int n = Integer.parseInt(str);

        for (int i = n - (len * 9); i < n; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum + i == n) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //자릿수의 길이를 알기 위해 일단 문자열로 입력 받음.
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}

