import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q에 넣어줄 좌표 클래스
class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int M, N, sum;
    static int[][] box;
    static Queue<Point> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        // 토마토가 처음부터 익어있었던 상황과 모두 익지 못하는 상황을 알기 위한 변수
        sum = M * N;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) { // 익은 토마토의 좌표를 Q에 넣음
                    Q.offer(new Point(i, j));
                    sum--;
                } else if (box[i][j] == -1) {
                    sum--;
                }
            }
        }

        if (sum == 0) { // 처음부터 모두 익었던 상황
            System.out.println(0);
        } else {
            System.out.println(BFS());
        }
    }

    private static int BFS() {

        int[] dy = {1, 0, -1, 0}; //위 아래
        int[] dx = {0, 1, 0, -1}; // 왼쪽 오른쪽

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Point now = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];
                    if (ny >= 0 && nx >= 0 && ny < N && nx < M && box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        Q.offer(new Point(ny, nx));
                        sum--;
                    }
                }
            }

            level++;
            if (sum == 0) return level; //만약 sum == 0 이면 다음 While문이 작동되면안됨 level이 증가해버림 따라서 return 해주자.
        }

        return sum > 0 ? -1 : level;
    }
}

