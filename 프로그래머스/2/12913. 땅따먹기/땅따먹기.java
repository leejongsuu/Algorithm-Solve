class Solution {
    
    int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n][m];
        for(int col = 0; col < m; col++) {
            dp[0][col] = land[0][col];
        }
       
        for(int row = 1; row < n; row++) {
            for(int col = 0; col < m; col++) {
                int max = 0;
                for(int k = 0; k < m; k++) {
                    if(col == k) continue;
                    max = Math.max(max, land[row][col] + dp[row - 1][k]);
                }
                dp[row][col] = max;
            }
        }
        
        int result = 0;
        for(int col = 0; col < m; col++) {
            result = Math.max(result, dp[n - 1][col]);
        }
        
        return result;
    }
}