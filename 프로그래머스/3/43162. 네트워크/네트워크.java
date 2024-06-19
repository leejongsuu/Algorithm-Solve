class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < computers.length; i++) {
            for(int j =0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    answer++;
                    DFS(i, computers);
                }
            }
        }
        
        return answer;
    }
    
    private void DFS(int v, int[][] computers) {
        
        for(int i = 0; i < computers.length; i++) {
            if(computers[v][i] == 1) {
                computers[v][i] = computers[i][v] = 0;
                DFS(i, computers);
            }
        }
    }
}