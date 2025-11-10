class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int r = 1; r < n; r++) {
            dp[r][0] = triangle[r][0] + dp[r - 1][0];
        }
        
        for(int r = 1; r < n; r++) {
            for(int c = 1; c <= r; c++) {
                dp[r][c] = Math.max(dp[r - 1][c], dp[r - 1][c - 1]) + triangle[r][c];
            }
        }
        
        int max = 0;
        for(int c = 0; c < n; c++) {
            max = Math.max(max, dp[n - 1][c]);
        }
        
        return max;
    }
}