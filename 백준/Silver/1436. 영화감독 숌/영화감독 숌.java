import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 666, cnt = 1;

        while (N != cnt) {
            num++;

            //int형인 num을 String으로 변환한 뒤, "666"이란 문자열이 있는지 검사
            if (String.valueOf(num).contains("666")){
                cnt++;
            }
        }

        System.out.println(num);
    }
}