import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        
        int row = maps.length;
        int col = maps[0].length;
        
        int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0,1});
        
        while(!Q.isEmpty()) {
            int[] current = Q.poll();
            
            if(current[0] ==  row - 1 && current[1] == col -1) return current[2];
            
            for(int[] dir : direction) {
                int ny = current[0] + dir[0];
                int nx = current[1] + dir[1];
                int distance = current[2];
                if(ny>=0 && nx>=0 && ny < row && nx< col && maps[ny][nx]==1) {
                    maps[ny][nx] = 0;
                    Q.offer(new int[]{ny,nx, distance + 1});
                }
            }
        }
        
        return -1;
    }
}