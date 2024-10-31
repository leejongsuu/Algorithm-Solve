class Solution {
    
    static int result = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        DFS(0, k, dungeons);
        
        return result;
    }
    
    private void DFS(int L, int k, int[][] dungeons) {
        
        if(L > result) {
            result = L;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] &&dungeons[i][0] <= k) {
                visited[i] = true;
                DFS(L+1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}