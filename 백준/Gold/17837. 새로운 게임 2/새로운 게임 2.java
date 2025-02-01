import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Horse {
        int n, y, x, d;

        public Horse(int n, int y, int x, int d) {
            this.n = n;
            this.y = y;
            this.x = x;
            this.d = d;
        }

        public void moveHorse(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setD(int d) {
            this.d = d;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(n);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Horse horse = (Horse) obj;
            return n == horse.n;
        }
    }

    static int N, K;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] chess;
    static Horse[] horses;
    static ArrayList<Horse>[][] horseList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chess = new int[N][N];
        horses = new Horse[K + 1];
        horseList = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
                horseList[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            horses[i] = new Horse(i, y, x, d);
            horseList[y][x].add(horses[i]);
        }

        int result = solution();

        System.out.println(result);
    }

    public static int solution() {
        int turn = 0;
        final int INF = 1001;

        while (turn < INF) {
            turn++;
            for (int i = 1; i <= K; i++) {
                Horse current = horses[i];

                int cy = current.y;
                int cx = current.x;
                int cd = current.d;

                int ny = cy + dy[cd];
                int nx = cx + dx[cd];

                if (!isIn(ny, nx) || chess[ny][nx] == 2) {
                    current.setD(changeDir(cd));

                    ny = cy + dy[current.d];
                    nx = cx + dx[current.d];

                    if (!isIn(ny, nx) || chess[ny][nx] == 2) {
                        continue;
                    }
                }

                int index = horseList[cy][cx].indexOf(current);
                List<Horse> movingHorse = new ArrayList<>(horseList[cy][cx].subList(index, horseList[cy][cx].size()));
                horseList[cy][cx].subList(index, horseList[cy][cx].size()).clear();

                if (chess[ny][nx] == 1) {
                    Collections.reverse(movingHorse);
                }

                for (Horse horse : movingHorse) {
                    horseList[ny][nx].add(horse);
                    horse.moveHorse(ny, nx);
                }

                if (horseList[ny][nx].size() >= 4) {
                    return turn;
                }
            }
        }

        return -1;
    }

    public static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    public static int changeDir(int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
            default:
                return -1;
        }
    }
}
