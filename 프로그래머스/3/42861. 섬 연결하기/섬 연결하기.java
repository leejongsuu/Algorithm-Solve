import java.util.*;

class Solution {
    
    int[] unf;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        unf = new int[n];
        
        for(int i = 0; i < n; i++) {
            unf[i] = i;
        }
        
        for(int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            if(find(from) != find(to)) {
                union(from, to);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    
    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) {
            unf[fa] = fb;
        }
    }
}