class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int result = 0;
        int n = board.length;
        int[] dy = new int[]{1,0,-1,0};
        int[] dx = new int[]{0,1,0,-1};
        
        String color = board[h][w];
        for(int i = 0; i < 4; i++) {
            int ny = h + dy[i];
            int nx = w + dx[i];
            
            if(ny>=0 && nx>=0 && ny < n && nx < n && board[ny][nx].equals(color)) {
                result++;
            }
        }
        
        return result;
    }
}