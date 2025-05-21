import java.util.*;

class Solution {
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] triangle;
    public int[] solution(int n) {
        
        triangle = new int[n][n];
    
        dfs(0, 0, n, 1, n);
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(triangle[i][j] != 0) {
                    list.add(triangle[i][j]);
                }
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    void dfs(int r, int c, int level, int num, int n) {
        
        for(int i = 0; i < level - 1; i++) {
            triangle[r][c] = num++;
            r += 1;
        }
        triangle[r][c] = num++;
        
        level--;
        if(level == 0) return;
        c += 1;
        
        for(int i = 0; i < level - 1; i++) {
            triangle[r][c] = num++;
            c += 1;
        }
        triangle[r][c] = num++;
        
        level--;
        if(level == 0) return;
        r -= 1;
        
        for(int i = 0; i < level - 1; i++) {
            triangle[r][c] = num++;
            r -= 1;
        }
        triangle[r][c] = num++;
        
        level--;
        if(level == 0) return;
        
        dfs(r + 1, n - c, level, num, n);
    }
}