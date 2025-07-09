import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        int n = line.length;
        // 1) 모든 쌍의 교점 계산
        for (int i = 0; i < n - 1; i++) {
            long A = line[i][0], B = line[i][1], E = line[i][2];
            for (int j = i + 1; j < n; j++) {
                long C = line[j][0], D = line[j][1], F = line[j][2];

                long div = A * D - B * C;
                if (div == 0) continue;

                // 교점 (x, y) = ((B*F - E*D)/div, (E*C - A*F)/div)
                long numX = B * F - E * D;
                long numY = E * C - A * F;
                if (numX % div != 0 || numY % div != 0) continue;

                long x = numX / div;
                long y = numY / div;

                points.add(new long[]{x, y});
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int width  = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] grid = new char[height][width];

        for (int r = 0; r < height; r++) {
            Arrays.fill(grid[r], '.');
        }

        for (long[] p : points) {
            int gx = (int)(p[0] - minX);
            int gy = (int)(maxY - p[1]);
            grid[gy][gx] = '*';
        }

        String[] answer = new String[height];
        for (int r = 0; r < height; r++) {
            answer[r] = new String(grid[r]);
        }
        
        return answer;
    }
}
