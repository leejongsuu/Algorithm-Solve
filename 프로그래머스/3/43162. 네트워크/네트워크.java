class Solution {
    public int solution(int n, int[][] computers) {
        
        int result = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                result++;
                dfs(i, n, visited, computers);
            }
        }
        
        return result;
    }
    
    public void dfs(int current, int n, boolean[] visited, int[][] computers) {
        visited[current] = true;
        
        for(int next = 0; next < n; next++) {
            if(computers[current][next] == 1 && !visited[next]) {
                dfs(next, n, visited, computers);
            }
        }
    }
}