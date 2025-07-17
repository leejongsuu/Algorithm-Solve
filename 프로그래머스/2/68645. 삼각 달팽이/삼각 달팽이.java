class Solution {
    public int[] solution(int n) {
        
        int size = n * (n + 1) / 2;
        int[] result = new int[size];
        int[][] triangle = new int[n][n];
        
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        
        int r = 0, c = 0, d = 0;
        for(int num = 1; num <= size; num++) {
            triangle[r][c] = num;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nc < 0 || nr >= n || nc >= n || triangle[nr][nc] != 0) {
                d = (d + 1) % 3;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            
            r = nr;
            c = nc;
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(triangle[i][j] > 0) {
                    result[idx++] = triangle[i][j];
                }
            }
        }
        
        return result;
    }
}