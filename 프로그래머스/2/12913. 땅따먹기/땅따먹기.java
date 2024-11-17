class Solution {
    int solution(int[][] land) {
        int size = land.length;
        
        int[][] dp = new int[size][4];
        
        for(int col = 0; col < 4; col++) {
            dp[0][col] = land[0][col];
        }
        
        for(int row = 1; row < size; row++) {
            dp[row][0] = Math.max(Math.max(dp[row-1][1], dp[row-1][2]), dp[row-1][3]) + land[row][0];
            dp[row][1] = Math.max(Math.max(dp[row-1][0], dp[row-1][2]), dp[row-1][3]) + land[row][1];
            dp[row][2] = Math.max(Math.max(dp[row-1][0], dp[row-1][1]), dp[row-1][3]) + land[row][2];
            dp[row][3] = Math.max(Math.max(dp[row-1][0], dp[row-1][1]), dp[row-1][2]) + land[row][3];
        }
        
        return Math.max(Math.max(dp[size-1][0], dp[size-1][1]), Math.max(dp[size-1][2], dp[size-1][3]));
    }
}