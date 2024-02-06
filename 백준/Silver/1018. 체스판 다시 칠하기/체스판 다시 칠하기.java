import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static boolean[][] arr;

    public int solution(int n, int m) {
        int min = 64;
        int n_row = n - 7;
        int m_col = m - 7;

        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_col; j++) {
                min = Math.min(min, find(i, j));
            }
        }

        return min;
    }

    public int find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                if (arr[i][j] != TF) {
                    count++;
                }

                TF = !TF;
            }
            TF = !TF;
        }

        return Math.min(count, 64 - count);
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new boolean[n][m];
        String str;

        //배열 입력
        for (int i = 0; i < n; i++) {
            str = br.readLine();

            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        System.out.println(T.solution(n, m));
    }
}