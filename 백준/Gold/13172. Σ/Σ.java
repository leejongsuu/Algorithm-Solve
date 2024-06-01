import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

    static final int mod = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            answer += Calculate(S, N);
            answer %= mod;
        }

        System.out.println(answer);
    }

    private static int Calculate(int a, int b) {
        BigInteger bigMod = BigInteger.valueOf(mod);
        BigInteger big = new BigInteger(BigInteger.valueOf(b).toString());
        big = big.modPow(BigInteger.valueOf(mod - 2), bigMod);
        big = big.multiply(BigInteger.valueOf(a)).mod(bigMod);
        return big.intValue();
    }

}
