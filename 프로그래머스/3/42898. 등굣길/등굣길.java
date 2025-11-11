class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        
        final int MOD = 1_000_000_007;
        
        int[][] dp = new int[n][m];
        
        for(int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int r = 1; r < n; r++) {
            if(dp[r][0] == -1 || dp[r - 1][0] == 0) {
                dp[r][0] = 0; 
            } else {
                dp[r][0] = 1;
            }
        }
        
        for(int c = 1; c < m; c++) {
            if(dp[0][c] == -1 || dp[0][c - 1] == 0) {
                dp[0][c] = 0;
            } else {
                dp[0][c] = 1;
            }
        }
        
        for(int r = 1; r < n; r++) {
            for(int c = 1; c < m; c++) {
                
                if(dp[r][c] == -1) {
                    dp[r][c] = 0;
                    continue;
                }
                
                int fromUp = dp[r - 1][c];
                int fromLeft = dp[r][c - 1];
                
                dp[r][c] = (int)(((long)fromUp + fromLeft) % MOD);
            }
        }

        return dp[n - 1][m - 1];
    }
}