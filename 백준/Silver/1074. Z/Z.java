import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int r, c, result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, N);

        solve(0, 0, size);

        System.out.println(result);
    }

    static void solve(int row, int col, int size) {

        if (size == 1) {
            return;
        }

        int newSize = size / 2;

        if (r < row + newSize && c < col + newSize) {
            solve(row, col, newSize);   // 2사분면
        }
        if (r < row + newSize && col + newSize <= c) {
            result += (size * size) / 4;    //1사분면
            solve(row, col + newSize, newSize);
        }
        if (row + newSize <= r && c < col + newSize) {
            result += ((size * size) / 4) * 2;    //3사분면
            solve(row + newSize, col, newSize);
        }
        if (row + newSize <= r && col + newSize <= c) {
            result += ((size * size / 4)) * 3;    //4사분면
            solve(row + newSize, col + newSize, newSize);
        }
    }
}