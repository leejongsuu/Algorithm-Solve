import java.util.HashMap;

class Solution {
    
    class Point {
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
    static int n, m;
    
    public int[] solution(String[] park, String[] routes) {
        
        n = park.length;
        m = park[0].length();
        
        HashMap<Character, Point> dirMap = new HashMap<>();
        dirMap.put('N', new Point(-1, 0));
        dirMap.put('S', new Point(1, 0));
        dirMap.put('W', new Point(0, -1));
        dirMap.put('E', new Point(0, 1));
        
        Point point = getStartPoint(park);
        
        for(String route : routes) {
            String[] splited = route.split(" ");
            
            Point dirPoint = dirMap.get(splited[0].charAt(0));
            int cnt = Integer.parseInt(splited[1]);
            
            int ny = point.y + (dirPoint.y * cnt);
            int nx = point.x + (dirPoint.x * cnt);
            
            if(isIn(ny, nx)) {
                boolean flag = true;
                switch(splited[0].charAt(0)) {
                    case 'N' -> flag = isNotBlocked(ny, point.y , nx, point.x, park);
                    case 'S' -> flag = isNotBlocked(point.y, ny, nx, point.x, park);
                    case 'W' -> flag = isNotBlocked(ny, point.y , nx, point.x, park);
                    case 'E' -> flag = isNotBlocked(ny, point.y , point.x, nx, park);   
                }
                if(flag) {
                    point.setPoint(ny, nx);
                }
            }
        }
        return new int[]{point.y, point.x};
    }
    
    private Point getStartPoint(String[] park) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(park[i].charAt(j) == 'S') {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }
    
    private boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
    
    private boolean isNotBlocked(int y1, int y2, int x1, int x2, String[] park) {
        
        boolean flag = true;
        for(int i = y1; i <= y2; i++) {
            for(int j = x1; j <= x2; j++) {
                if(park[i].charAt(j) == 'X') {
                    return false;
                }
            }
        }
        return flag;
    }
    
    
}