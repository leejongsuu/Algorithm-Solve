import java.util.*;

class Solution {
    
    int n, m;
    char[][] ch;
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
              
        n = storage.length;
        m = storage[0].length();
        
        int result = n * m;
        
        ch = new char[n][m];
        for(int i = 0; i < n; i++) {
            ch[i] = storage[i].toCharArray();
        }
        
        for(String request : requests) { 
            int command = request.length();
            if(command > 1) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(ch[i][j] == request.charAt(0)) {
                            result--;
                            ch[i][j] = '-';
                        }
                    }
                }
            } else {
                List<int[]> list = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(ch[i][j] == request.charAt(0)) {
                            if(isAccessible(i, j, new boolean[n][m])) {
                                list.add(new int[]{i,j});
                                result--;
                            }
                        }
                    }
                }
                for(int[] pos : list) {
                    ch[pos[0]][pos[1]] = '-';
                }
            }
        }
        
        return result;
    }
      
    boolean isAccessible(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(!isIn(nr, nc)) {
                return true;
            }
            
            if(!visited[nr][nc] && ch[nr][nc] == '-') {
                if(isAccessible(nr, nc, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}