import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = BFS(N, M, graph);

        System.out.println(result[0] + "\n" + result[1]);
    }

    private static int[] BFS(int n, int m, int[][] graph) {

        int time = 0;
        int lastCheese = 0;

        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{0, 1, 0, -1};


        while (true) {

            Queue<Point> airQueue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];

            airQueue.offer(new Point(0, 0));
            visited[0][0] = true;

            while (!airQueue.isEmpty()) {
                Point cur = airQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && graph[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        airQueue.offer(new Point(ny, nx));
                    }
                }
            }

            Queue<Point> cheeseQueue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if (ny >= 0 && nx >= 0 && ny < n && nx < m && visited[ny][nx]) {
                                cheeseQueue.offer(new Point(i, j));
                                break;
                            }
                        }
                    }
                }
            }

            if (cheeseQueue.isEmpty()) {
                break;
            }
            lastCheese = cheeseQueue.size();
            for (Point p : cheeseQueue) {
                graph[p.y][p.x] = 0;
            }

            time++;
        }


        return new int[]{time, lastCheese};
    }
}
