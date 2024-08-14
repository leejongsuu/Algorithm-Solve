import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static final int N = 8;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> boardMap = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            boardMap.put((char) ('a' + i), i);
        }

        int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {1, -2},
                {2, -1}, {2, 1}, {-1, 2}, {1, 2}};

        String pos = br.readLine();
        int count = 0;

        int x = boardMap.get(pos.charAt(0));
        int y = pos.charAt(1) - '0' - 1;

        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if (isIn(nextY, nextX)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isIn(int y, int x) {
        return x >= 0 && y >= 0 && y < N && x < N;
    }
}
