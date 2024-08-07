class Solution {

    static int n, m;
    static int[] dy = new int[]{1,0,-1,0};
    static int[] dx = new int[]{0,1,0,-1}; 

    public int[] solution(String[] park, String[] routes) {
        
        n = park.length;
        m = park[0].length();
        
        int[] start = init(park);
        int y = start[0];
        int x = start[1];
        
        for(String route : routes) {
            String[] sub = route.split(" ");
            String dir = sub[0];
            int cnt = Integer.parseInt(sub[1]);
            
            int index = -1;
            switch(dir) {
                case "S" -> index = 0;
                case "E" -> index = 1;
                case "N" -> index = 2;
                case "W" -> index = 3;
            }
            
            int ny = y + cnt * dy[index];
            int nx = x + cnt * dx[index];
            
            if(!isIn(ny, nx)) continue;
            if(isBlocked(y, x, ny, nx, park)) continue;
            
            y = ny;
            x = nx;
            
        }
        
        return new int[]{y, x};
    }
    
    public int[] init(String[] park) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    
    public boolean isBlocked(int y, int x, int ny, int nx, String[] park) {
        
        if(y > ny) {
            int temp = y;
            y = ny;
            ny = temp;
        }
        if(x > nx) {
            int temp = x;
            x = nx;
            nx = temp;
        }
        
        for(int i = y; i <= ny; i++) {
            for(int j = x; j <= nx; j++) {
                if(park[i].charAt(j) == 'X') {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isIn(int y, int x) {
        return y < n && x < m && y >= 0 && x >=0;
    }
}
