import java.util.Map;
import java.util.HashMap;

class Solution {
    
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        
        Map<String, Point> dirMap = new HashMap<>();
        dirMap.put("up", new Point(0,1));
        dirMap.put("down", new Point(0,-1));
        dirMap.put("left", new Point(-1,0));
        dirMap.put("right", new Point(1,0));
        
        int boundaryX = board[0] / 2 + 1;
        int boundaryY = board[1] / 2 + 1;
        
        Point current = new Point(0, 0);
        for(String key : keyinput) {
            Point next = dirMap.get(key);
            int nx = current.x + next.x;
            int ny = current.y + next.y;
            if(Math.abs(nx) < boundaryX && Math.abs(ny) < boundaryY) {
                current = new Point(nx, ny);
            }
        }
        
        return new int[]{current.x, current.y};
    }
}
