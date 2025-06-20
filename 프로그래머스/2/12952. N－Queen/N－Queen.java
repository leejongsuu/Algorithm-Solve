class Solution {
    int result = 0;
    boolean[] colUsed;
    boolean[] diag1Used;
    boolean[] diag2Used;
    
    public int solution(int n) {
        colUsed = new boolean[n];
        diag1Used = new boolean[2 * n - 1];
        diag2Used = new boolean[2 * n - 1];
        
        dfs(0, n);
        
        return result;
    }
    
    void dfs(int row, int n) {
        if(row == n) {
            result++;
            return;
        }
        
        for(int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);
            int d2 = row + col;
            if(!colUsed[col] && !diag1Used[d1] && !diag2Used[d2]) {
                colUsed[col] = true;
                diag1Used[d1] = true;
                diag2Used[d2] = true;
                
                dfs(row + 1, n);
                
                colUsed[col] = false;
                diag1Used[d1] = false;
                diag2Used[d2] = false;
            }
        }
    }
}