import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stars = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        star(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stars[i].length; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void star(int r, int c, int size) {
        if (size == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
            return;
        }

        int newSize = size / 2;
        star(r, c, newSize);
        star(r + newSize, c - newSize, newSize);
        star(r + newSize, c + newSize, newSize);
    }
}
