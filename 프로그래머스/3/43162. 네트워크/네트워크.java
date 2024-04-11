class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                DFS(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public void DFS(int v, int n, int[][] computers) {
        
        visited[v] = true;
        
        for(int[] computer : computers) {
            for(int i=0; i < n; i++) {
                
                if(computer[v] == 1 && computer[i] == 1 && !visited[i]) {
                    DFS(i, n, computers);
                }
            }
        }
    }
}