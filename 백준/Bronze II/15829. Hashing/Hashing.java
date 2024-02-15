import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public long solution(String str) {

        int prime = 1234567891;
        long r = 1;
        long sum = 0;

        for (char c : str.toCharArray()) {
            sum += (((c - 'a') + 1) * r) % prime;
            r = (r * 31) % prime;
        }

        return sum % prime;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}