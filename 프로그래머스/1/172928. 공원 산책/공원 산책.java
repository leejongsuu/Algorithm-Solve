import java.util.Map;
import java.util.HashMap;

class Solution {
    
    static class Point {
        int y, x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        public void setPoint(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int[] solution(String[] park, String[] routes) {
        
        Map<String, Point> dirMap = new HashMap<>();
        init(dirMap);
        
        int n = park.length;
        int m = park[0].length();
        
        Point current = getStartPoint(n, m, park);
        
        for(String route : routes) {
            String[] dir = route.split(" ");
            
            Point next = dirMap.get(dir[0]);
            int ny = current.y + next.y * Integer.parseInt(dir[1]);
            int nx = current.x + next.x * Integer.parseInt(dir[1]);
            
            if(isIn(ny, nx, n, m)) {
                boolean flag = true;
                switch (dir[0]) {
                        case "N" -> 
                            flag = isBlocked(park, ny, current.y, current.x, nx);
                        case "S" -> 
                            flag = isBlocked(park, current.y, ny, nx, current.x);
                        case "E" -> 
                            flag = isBlocked(park, current.y, ny, current.x, nx);
                        case "W" -> 
                            flag = isBlocked(park, current.y, ny, nx, current.x);
                }
                if(!flag) {
                    current.setPoint(ny, nx);
                }
            }
        }
        
        return new int[]{current.y, current.x};
    }
    
    private boolean isBlocked(String[] park, int y1, int y2, int x1, int x2) {
        for(int i = y1; i <= y2; i++) {
            for(int j = x1; j <= x2; j++) {
                if(park[i].charAt(j) == 'X') {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isIn(int y, int x, int n, int m) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
    
    private void init(Map<String, Point> dirMap) {
        dirMap.put("N", new Point(-1, 0));
        dirMap.put("S", new Point(1, 0));
        dirMap.put("E", new Point(0, 1));
        dirMap.put("W", new Point(0, -1));
    }
    
    private Point getStartPoint(int n, int m, String[] park) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(park[i].charAt(j) == 'S') {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }
    
}