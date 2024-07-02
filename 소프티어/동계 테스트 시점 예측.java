import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int y, x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = BFS(N, M, graph);

        System.out.println(result);
    }

    private static int BFS(int n, int m, int[][] graph) {

        int[] dy = new int[]{1,0,-1,0};
        int[] dx = new int[]{0,1,0,-1};
        
        int level = 0;
        while(true) {

            boolean[][] visited = new boolean[n][m];
            Queue<Point> airQueue = new LinkedList<>();
            airQueue.offer(new Point(0, 0));
            visited[0][0] = true;
    
            while(!airQueue.isEmpty()) {
                Point cur = airQueue.poll();
                for(int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if(isIn(ny, nx, n, m) && !visited[ny][nx] && graph[ny][nx] == 0) {
                        airQueue.offer(new Point(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
            
            Queue<Point> iceQueue = new LinkedList<>();
            // 바깥 공기와 접촉한(2면) 얼음 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if (isIn(ny, nx, n, m) && visited[ny][nx]) {
                                cnt++;
                            }
                        }
                        if(cnt >= 2) {
                            iceQueue.offer(new Point(i, j));
                        }
                    }
                }
            }

            if(iceQueue.isEmpty()) {
                return level;
            }
            for(Point point : iceQueue) {
                graph[point.y][point.x] = 0;
            }
            level++;
        }
    }

    private static boolean isIn(int y, int x, int n, int m) {
        return y>=0 && x >=0 && y < n && x < m;
    }
}
