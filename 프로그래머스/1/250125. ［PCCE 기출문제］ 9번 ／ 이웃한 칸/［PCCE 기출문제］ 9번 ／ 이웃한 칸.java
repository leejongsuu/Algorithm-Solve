class Solution {
    
    static int n, m;
    
    public int solution(String[][] board, int h, int w) {
        
        int result = 0;
        
        String color = board[h][w];
        
        n = board.length;
        m = board[0].length;
        
        int[] dy = new int[]{1,0,-1,0};
        int[] dx = new int[]{0,1,0,-1};
        
        for(int i = 0; i < 4; i++) {
            int ny = h + dy[i];
            int nx = w + dx[i];
            if(isIn(ny,nx) && board[ny][nx].equals(color)) {
                result++;
            }
        }
        return result;
    }
    
    private boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}