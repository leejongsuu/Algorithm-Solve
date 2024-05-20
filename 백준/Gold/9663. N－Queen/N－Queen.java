import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;
    private static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N];
        solveNQueen(0, N);
        System.out.println(count);
    }

    private static void solveNQueen(int row, int N) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col, N)) {
                board[row] = col;
                solveNQueen(row + 1, N);
            }
        }
    }

    private static boolean isSafe(int row, int col, int N) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
