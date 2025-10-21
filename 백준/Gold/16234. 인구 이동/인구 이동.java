import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int[][] land;
    final static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        land = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (day <= 2000) {

            boolean[][] check = new boolean[N][N];

            boolean isMove = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check[i][j]) {
                        check[i][j] = true;
                        if (move(i, j, check) != -1) {
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) {
                break;
            }

            day++;
        }

        System.out.println(day);
    }

    private static int move(int r, int c, boolean[][] check) {

        List<int[]> list = new LinkedList<>();
        list.add(new int[]{r, c});

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        int population = land[r][c];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] dir : dirs) {
                int nr = current[0] + dir[0];
                int nc = current[1] + dir[1];

                if (isIn(nr, nc) && !check[nr][nc]) {
                    int sub = Math.abs(land[nr][nc] - land[current[0]][current[1]]);
                    if (sub >= L && sub <= R) {
                        population += land[nr][nc];
                        queue.offer(new int[]{nr, nc});
                        list.add(new int[]{nr, nc});
                        check[nr][nc] = true;
                    }
                }
            }
        }

        int size = list.size();
        if (size == 1) {
            return -1;
        } else {
            int newPopulation = population / size;
            for (int[] pos : list) {
                land[pos[0]][pos[1]] = newPopulation;
            }
            return newPopulation;
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}