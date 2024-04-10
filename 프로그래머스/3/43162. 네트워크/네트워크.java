import java.util.*;

class Solution {
    
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        
        visited = new boolean[n];
        boolean[][] check = new boolean[n][n];
        for(int[] computer : computers) {
            for(int i=0; i<n-1; i++) {
                
                if(computer[i]==0) continue;
                
                for(int j=i+1; j<n; j++){
                    if(computer[j]==1) {
                        if(!check[i][j]) {
                            list.get(i).add(j);
                            list.get(j).add(i);
                            check[i][j] = check[j][i] = true;
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                DFS(i, list);
            }
        }
        
        return answer;
    }
    
    public void DFS(int v, ArrayList<ArrayList<Integer>> list) {
        
        for(int next : list.get(v)) {
            if(!visited[next]) {
                visited[next] = true;
                DFS(next, list);
            }
        }
    }
}