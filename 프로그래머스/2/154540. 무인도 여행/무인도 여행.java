import java.util.*;

class Solution {
    int n, m;
    boolean[][] visited;
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        List<Integer> resultList = new ArrayList<>();

        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int islandSum = dfs(i, j, maps);
                    resultList.add(islandSum);
                }
            }
        }

        if (resultList.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(resultList);
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int y, int x, String[] maps) {
        visited[y][x] = true;
        int sum = maps[y].charAt(x) - '0';

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (inRange(ny, nx)
                    && !visited[ny][nx]
                    && maps[ny].charAt(nx) != 'X') {
                sum += dfs(ny, nx, maps);
            }
        }
        return sum;
    }

    private boolean inRange(int y, int x) {
        return (y >= 0 && y < n && x >= 0 && x < m);
    }
}
