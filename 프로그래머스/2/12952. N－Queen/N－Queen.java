class Solution {
    int result = 0;
    boolean[] colUsed, diagUsed, diag2Used;
    
    public int solution(int n) {
        colUsed = new boolean[n];
        diagUsed = new boolean[2 * n - 1];
        diag2Used = new boolean[2 * n - 1];
        
        canPlace(0, n);
        
        return result;
    }
    
    private void canPlace(int row, int n) {
        if(row == n) {
            result++;
            return;
        }
        
        for(int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);
            int d2 = row + col;
            if(!colUsed[col] && !diagUsed[d1] && !diag2Used[d2]) {
                colUsed[col] = true;
                diagUsed[d1] = true;
                diag2Used[d2] = true;
                
                canPlace(row + 1, n);
                
                colUsed[col] = false;
                diagUsed[d1] = false;
                diag2Used[d2] = false;
            }
        }
    }
}