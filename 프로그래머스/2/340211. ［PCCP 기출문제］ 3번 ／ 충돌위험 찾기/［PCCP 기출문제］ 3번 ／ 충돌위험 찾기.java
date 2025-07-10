import java.util.*;

class Solution {
    
    class Road {
        private int r;
        private int c;
        private int t;
        
        public Road(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(r, c, t);
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            else if(!(obj instanceof Road)) return false;
            
            Road other = (Road) obj;
            return r == other.r && c == other.c && t == other.t;
        } 
    }
        
    public int solution(int[][] points, int[][] routes) {

        int result = 0;
        
        Map<Road, Integer> map = new HashMap<>();
        
        for(int[] route : routes) {
            int r = points[route[0] - 1][0];
            int c = points[route[0] - 1][1];
            int t = 0;
            
            map.merge(new Road(r, c, t), 1, Integer::sum);
            
            for(int i = 1; i < route.length; i++) {
                int nr = points[route[i] - 1][0];
                int nc = points[route[i] - 1][1];
                
                while (r != nr) {
                    t++;
                    r += (nr > r ? 1 : -1);
                    map.merge(new Road(r,c,t), 1, Integer::sum);
                }
                while (c != nc) {
                    t++;
                    c += (nc > c ? 1 : -1);
                    map.merge(new Road(r,c,t), 1, Integer::sum);
                }
            }
        }
        
        for(int count : map.values()) {
            if(count > 1) result++;
        }
        
        return result;
    }
}