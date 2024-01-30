import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public int solution(String str) {

        int sum = 0, i = 0;
        for (char c : str.toCharArray()) {
            sum += ((c - 'a') + 1) * Math.pow(31, i);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}