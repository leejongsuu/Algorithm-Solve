class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        
        int max = 0;
        
        // 첫 행과 첫 열은 그대로 복사
        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0];
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = board[0][j];
            max = Math.max(max, dp[0][j]);
        }
        
        // 나머지 셀 계산
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(
                        Math.min(dp[i-1][j], dp[i][j-1]),
                        dp[i-1][j-1]
                    ) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}
