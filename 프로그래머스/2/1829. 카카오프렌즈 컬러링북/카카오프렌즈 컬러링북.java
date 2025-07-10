class Solution {
    
    int M, N, areaCount = 0, maxAreaCount = 0;
    boolean[][] visited;
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        this.M = m;
        this.N = n;
        
        visited = new boolean[M][N];
        
        int area = 0;
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(!visited[r][c] && picture[r][c] != 0) {
                    area++;
                    areaCount = 0;
                    dfs(r, c, picture);
                    maxAreaCount = Math.max(maxAreaCount, areaCount);
                }
            }
        }
        
        return new int[]{area, maxAreaCount};
    }
    
    void dfs(int r, int c, int[][] picture) {
        visited[r][c] = true;
        areaCount++;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(isIn(nr,nc) && !visited[nr][nc] && picture[r][c] == picture[nr][nc]) {
                dfs(nr , nc, picture);
            }
        }
    }
    
    boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }
}