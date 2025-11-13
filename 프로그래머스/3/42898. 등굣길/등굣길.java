class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        final int MOD = 1_000_000_007;
        
        int[][] board = new int[n + 1][m + 1];
        
        for(int[] puddle : puddles) {
            board[puddle[1]][puddle[0]] = -1;
        }
        
        board[1][1] = 1;
        
        for(int r = 2; r <= n; r++) {
            if(board[r][1] == -1) {
                board[r][1] = 0;
                continue;
            }
            
            board[r][1] = board[r - 1][1] + board[r][0];
        }
        
        for(int c = 2; c <= m; c++) {
            if(board[1][c] == -1) {
                board[1][c] = 0;
                continue;
            }
            
            board[1][c] = board[1][c - 1] + board[0][c];
        }
        
        for(int r = 2; r <= n; r++) {
            for(int c = 2; c <= m; c++) {
                if(board[r][c] == -1) {
                    board[r][c] = 0;
                    continue;
                }
                
                board[r][c] = (board[r - 1][c] + board[r][c - 1]) % MOD;
            }
        }
        
        return board[n][m];
    }
}