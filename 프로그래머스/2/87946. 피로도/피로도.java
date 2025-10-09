class Solution {
    
    int size, result = 0;
    boolean isFound = false;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        visited = new boolean[size];
        dfs(0, k, dungeons);
        
        return result;
    }
    
    private void dfs(int L, int k, int[][] dungeons) {
        if(isFound) return;
        
        result = Math.max(result, L);
        
        if(L == size) {
            isFound = true;
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(L + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}