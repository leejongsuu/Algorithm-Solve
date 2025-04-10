import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int len = land.length;
        int[][] dp = new int[len][4];
        
        for(int c = 0; c < 4; c++) {
            dp[0][c] = land[0][c];
        }
        
        for(int r = 1; r < len; r++) {
            dp[r][0] =  land[r][0] + Math.max(dp[r-1][1], Math.max(dp[r-1][2], dp[r-1][3]));
            dp[r][1] =  land[r][1] + Math.max(dp[r-1][0], Math.max(dp[r-1][2], dp[r-1][3]));
            dp[r][2] =  land[r][2] + Math.max(dp[r-1][0], Math.max(dp[r-1][1], dp[r-1][3]));
            dp[r][3] =  land[r][3] + Math.max(dp[r-1][0], Math.max(dp[r-1][1], dp[r-1][2]));
        }
        
        return Arrays.stream(dp[len - 1]).max().getAsInt();
    }
}