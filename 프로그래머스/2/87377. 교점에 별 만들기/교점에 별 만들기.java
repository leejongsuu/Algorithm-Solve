import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<long[]> pointList = new ArrayList<>();
        
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        
        for(int i = 0; i < line.length - 1; i++) {
            long A = line[i][0], B = line[i][1], E = line[i][2];
            for(int j = i + 1; j < line.length; j++) {
                long C = line[j][0], D = line[j][1], F = line[j][2];
                
                long div = A*D - B*C;
                
                if(div == 0) continue;
                
                long x = (B*F - E*D) / div;
                long y = (E*C - A*F) / div;
                
                if(A*x + B*y + E != 0 || C*x + D*y + F != 0) continue;
                
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                
                pointList.add(new long[]{x, y});
            }
        }
        
        int width  = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] grid = new char[height][width];

        for (int r = 0; r < height; r++) {
            Arrays.fill(grid[r], '.');
        }
        
        for(long[] point : pointList) {
            int x = (int) (point[0] - minX);
            int y = (int) (maxY - point[1]);
            
            grid[y][x] = '*';
        }
        
        String[] result = new String[height];
        for(int r = 0; r < height; r++) {
            result[r] = new String(grid[r]);
        }
        
        return result;
    }
}