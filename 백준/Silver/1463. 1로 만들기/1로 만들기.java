import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int DFS(int n, int cnt) {

        if (n < 2) {
            return cnt;
        }

        /**
         * N으로 각각 2와 3으로 나누면 count는 +1에 각 연산의 나머지 값을 더해준 것이 된다.
         * 나머지 값은 빼기 1했을 때의 count 값과 같기 때문
         */
        return Math.min(DFS(n / 2, cnt + 1 + (n % 2)), DFS(n / 3, cnt + 1 + (n % 3)));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(DFS(N, 0));
    }
}