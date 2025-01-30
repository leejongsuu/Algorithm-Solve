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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] chess = new int[N][N];
        ArrayList<Horse>[][] horseList = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
                horseList[i][j] = new ArrayList<>();
            }
        }

        Horse[] horses = new Horse[K + 1];  // 말 번호별 관리

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            horses[i] = new Horse(i, y, x, d);
            horseList[y][x].add(horses[i]);
        }

        int turn = 0;

        while (turn <= 1000) {
            turn++;

            for (int i = 1; i <= K; i++) {  // 모든 말을 순서대로 이동
                Horse currentHorse = horses[i];
                int cy = currentHorse.y;
                int cx = currentHorse.x;
                int cd = currentHorse.d;

                int ny = cy + dy[cd];
                int nx = cx + dx[cd];

                if (!isIn(ny, nx) || chess[ny][nx] == 2) {  // 파란색 또는 범위 밖
                    currentHorse.setD(changeDir(cd));
                    ny = cy + dy[currentHorse.d];
                    nx = cx + dx[currentHorse.d];

                    if (!isIn(ny, nx) || chess[ny][nx] == 2) {  // 또 파란색이면 이동하지 않음
                        continue;
                    }
                }

                int index = horseList[cy][cx].indexOf(currentHorse);
                List<Horse> movingHorse = new ArrayList<>(horseList[cy][cx].subList(index, horseList[cy][cx].size()));
                horseList[cy][cx].subList(index, horseList[cy][cx].size()).clear();

                if (chess[ny][nx] == 1) {  // 빨간색이면 순서 반전
                    Collections.reverse(movingHorse);
                }

                for (Horse horse : movingHorse) {
                    horse.moveHorse(ny, nx);
                    horseList[ny][nx].add(horse);
                }

                if (horseList[ny][nx].size() >= 4) {  // 종료 조건
                    System.out.println(turn);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    private static int changeDir(int num) {
        switch (num) {
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

    private static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
