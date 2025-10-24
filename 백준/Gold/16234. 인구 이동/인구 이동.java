import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    final static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] country = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (day < 2000) {
            boolean[][] visited = new boolean[N][N];
            boolean isMove = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        if (move(i, j, country, visited)) {
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

    private static boolean move(int r, int c, int[][] country, boolean[][] visited) {

        int population = country[r][c];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        List<int[]> posStoreList = new LinkedList<>();
        posStoreList.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int[] dir : dirs) {
                int nr = current[0] + dir[0];
                int nc = current[1] + dir[1];

                if (isIn(nr, nc) && !visited[nr][nc]) {
                    int sub = Math.abs(country[current[0]][current[1]] - country[nr][nc]);
                    if (sub >= L && sub <= R) {
                        visited[nr][nc] = true;
                        population += country[nr][nc];
                        q.offer(new int[]{nr, nc});
                        posStoreList.add(new int[]{nr, nc});
                    }
                }
            }
        }

        int size = posStoreList.size();
        if (size > 1) {
            int newPopulation = population / size;
            for (int[] pos : posStoreList) {
                country[pos[0]][pos[1]] = newPopulation;
            }
            return true;
        }

        return false;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}