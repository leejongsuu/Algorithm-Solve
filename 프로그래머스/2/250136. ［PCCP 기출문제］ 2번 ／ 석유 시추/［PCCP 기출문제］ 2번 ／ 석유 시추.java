import java.util.*;

class Solution {
    
    int n, m;
    boolean[][] visited;
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    Set<Integer> colSet = new HashSet<>();
                    int loaf = getLandSize(i, j, land, colSet);
                    for(int col : colSet) {
                        map.put(col, map.getOrDefault(col, 0) + loaf);
                    }
                }
            }
        }
        
        int max = 0;
        for(int val : map.values()) {
            max = Math.max(max, val);
        }
        
        return max;
    }
    
    int getLandSize(int r, int c, int[][] land, Set<Integer> colSet) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
                
        visited[r][c] = true;
        
        int loaf = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            colSet.add(cur[1]);
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(isIn(nr, nc) && land[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    
                    queue.offer(new int[]{nr, nc});
                    loaf++;
                }
            }
        }
        
        return loaf;
    }
    
    boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}