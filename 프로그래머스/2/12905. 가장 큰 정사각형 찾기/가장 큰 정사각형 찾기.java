class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n][m];

        int max = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = board[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        
        for(int r = 1; r < n; r++) {
            for(int c = 1; c < m; c++) {
                if(dp[r][c] == 1) {
                    int min = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                    if(min > 0) {
                        dp[r][c] = min + 1;
                    }
                    max = Math.max(max, dp[r][c]);
                }
            }
        }
        
        return max * max;
    }
}