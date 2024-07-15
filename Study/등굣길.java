class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        final int mod = 1000000007;
        
        int[][] board = new int[n+1][m+1];
        
        for(int[] puddle : puddles) {
            board[puddle[1]][puddle[0]] = -1;
        }
        board[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j =1; j <= m; j++) {
                if(board[i][j] == -1) continue;
                if(board[i-1][j] > 0) board[i][j] += board[i-1][j] % mod;
                if(board[i][j-1] > 0) board[i][j] += board[i][j-1] % mod;
            }
        }
        return board[n][m] % mod;
    }
}
