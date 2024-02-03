import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수의 범위 (0~ 10000) 사실상 0은 제외
        int[] count = new int[10001];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        //0은 입력범위에서 없으므로 1부터 시작
        for (int i = 1; i < 10001; i++) {
            //i 값이 계수가 0이 될 때 까지 출력
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }

        System.out.println(sb);
    }
}