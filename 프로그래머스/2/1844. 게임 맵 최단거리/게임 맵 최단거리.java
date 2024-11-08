import java.util.*;

class Solution {
    
    class Point {
        int y;
        int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{0, 1, 0, -1};
        
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point current = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int ny = current.y + dy[j];
                    int nx = current.x + dx[j];
                    if(ny == n - 1 && nx == m - 1) {
                        return level + 1;
                    }
                    if(isIn(ny, nx, n, m) && maps[ny][nx] == 1) {
                        maps[ny][nx] = 0;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private boolean isIn(int y, int x, int n, int m) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}