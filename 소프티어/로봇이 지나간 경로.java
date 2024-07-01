import java.io.*;
import java.util.*;

public class Main {

    static int H, W, cnt = 0;
    static int minLength = Integer.MAX_VALUE;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // 서, 북, 동, 남
    static String result = "";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        graph = new char[H][W];
        visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                graph[i][j] = input.charAt(j);
                if (graph[i][j] == '#') {
                    cnt++;
                }
            }
        }

        int[] start = findStart();
        sb.append(start[0] + 1).append(' ').append(start[1] + 1).append('\n');
        sb.append(directionToChar(start[2])).append('\n');

        visited[start[0]][start[1]] = true;
        DFS(1, start[0], start[1], start[2], "");

        System.out.println(sb.toString() + result);
    }

    private static int[] findStart() {
        int min = Integer.MAX_VALUE;
        int[] start = new int[3];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] == '#') {
                    int neighborCount = 0;
                    int res = -1;

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dir[k][0];
                        int nx = j + dir[k][1];
                        if (isIn(ny, nx) && graph[ny][nx] == '#') {
                            neighborCount++;
                            res = k;
                        }
                    }

                    if (neighborCount < min && neighborCount > 0) {
                        min = neighborCount;
                        start[0] = i;
                        start[1] = j;
                        start[2] = res;
                    }
                }
            }
        }

        return start;
    }

    private static void DFS(int L, int y, int x, int way, String str) {
        if (L == cnt && str.length() < minLength) {
            minLength = str.length();
            result = str;
            return;
        }

        int nny = y + 2 * dir[way][0];
        int nnx = x + 2 * dir[way][1];
        if (isIn(nny, nnx) && graph[nny][nnx] == '#' && !visited[nny][nnx]) {
            int ny = y + dir[way][0];
            int nx = x + dir[way][1];
            visited[ny][nx] = true;
            visited[nny][nnx] = true;
            DFS(L + 2, nny, nnx, way, str + "A");
            visited[ny][nx] = false;
            visited[nny][nnx] = false;
        }

        // 왼쪽 회전
        int newWay = (way + 3) % 4;
        int ny = y + dir[newWay][0];
        int nx = x + dir[newWay][1];
        if (isIn(ny, nx) && graph[ny][nx] == '#' && !visited[ny][nx]) {
            DFS(L, y, x, newWay, str + "L");
        }

        // 오른쪽 회전
        newWay = (way + 1) % 4;
        ny = y + dir[newWay][0];
        nx = x + dir[newWay][1];
        if (isIn(ny, nx) && graph[ny][nx] == '#' && !visited[ny][nx]) {
            DFS(L, y, x, newWay, str + "R");
        }
    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    private static char directionToChar(int dir) {
        switch (dir) {
            case 0: return '<';
            case 1: return '^';
            case 2: return '>';
            case 3: return 'v';
            default: return ' ';
        }
    }
}
