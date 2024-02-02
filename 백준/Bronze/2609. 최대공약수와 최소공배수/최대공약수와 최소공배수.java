import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution(int n, int m) {

        int gcd = getGcd(n, m);

        System.out.println(gcd);
        System.out.println((n * m) / gcd);
    }
    
    public int getGcd(int a, int b) {
        
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] Input = br.readLine().split(" ");
        int n = Integer.parseInt(Input[0]);
        int m = Integer.parseInt(Input[1]);

        T.solution(n, m);
    }
}