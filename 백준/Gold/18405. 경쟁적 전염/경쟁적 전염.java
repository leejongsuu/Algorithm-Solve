import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Virus implements Comparable<Virus> {
        int kind;
        int r, c;

        public Virus(int kind, int r, int c) {
            this.kind = kind;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Virus o) {
            return this.kind - o.kind;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Virus> pq = new PriorityQueue<>();

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) {
                    pq.offer(new Virus(arr[i][j], i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int time = 0;
        while (!pq.isEmpty() && time < S) {
            int size = pq.size();

            List<Virus> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Virus current = pq.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = current.r + dirs[d][0];
                    int nc = current.c + dirs[d][1];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < N && arr[nr][nc] == 0) {
                        arr[nr][nc] = current.kind;
                        temp.add(new Virus(current.kind, nr, nc));
                    }
                }
            }

            for (Virus v : temp) {
                pq.offer(v);
            }

            time++;
        }

        System.out.println(arr[X][Y]);
    }
}