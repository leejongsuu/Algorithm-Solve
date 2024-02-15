import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solution(int h, int w, int n ) {
        int floor = n % h == 0 ? h : n % h;
        int roomNum = ((n - 1) / h) + 1;

        return (floor * 100) + roomNum;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String[] input;
        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            sb.append(solution(Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]), Integer.parseInt(input[2]))).append('\n');
        }

        System.out.println(sb);
    }
}