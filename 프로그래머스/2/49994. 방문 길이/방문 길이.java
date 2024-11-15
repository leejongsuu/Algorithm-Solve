class Solution {
    
    final int INF = 10;
    
    private class Chac {
        int y;
        int x;
        
        public Chac(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        public void moveU() {
            if(this.y < INF) {
                this.y += 1;
            }
        }
        
        public void moveD() {
            if(this.y > 0) {
                this.y -= 1;
            }
        }
        
        public void moveR() {
            if(this.x < INF) {
                this.x += 1;
            }
        }
        
        public void moveL() {
            if(this.x > 0) {
                this.x -= 1;
            }
        }
    }
    
    public int solution(String dirs) {
        
        int firstLoad = 0;
        Chac chac = new Chac(5, 5);
        
        boolean[][][][] visited = new boolean[INF + 1][INF + 1][INF + 1][INF + 1];
        
        for(char dir : dirs.toCharArray()) {
            int beforeY = chac.y;
            int beforeX = chac.x;
            switch(dir) {
                    case 'U' -> chac.moveU();
                    case 'D' -> chac.moveD();
                    case 'R' -> chac.moveR();
                    case 'L' -> chac.moveL();
            }
            int nextY = chac.y;
            int nextX = chac.x;
            if(!visited[beforeY][beforeX][nextY][nextX] && !(beforeY == nextY && beforeX == nextX)) {
                visited[beforeY][beforeX][nextY][nextX] = true;
                visited[nextY][nextX][beforeY][beforeX] = true;
                firstLoad++;    
            }
        }
        
        return firstLoad;
    }
}