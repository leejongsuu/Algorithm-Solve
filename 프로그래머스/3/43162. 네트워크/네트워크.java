import java.util.*;

class Solution {
    
    int[] unf;
    
    public int solution(int n, int[][] computers) {
        
        Set<Integer> set = new HashSet<>();
        
        unf = new int[n];
        for(int i = 0; i < n; i++) {
            unf[i] = i;
        }
        
        for(int[] computer : computers) {
            for(int i = 0; i < n - 1; i++) {
                if(computer[i] == 0) continue;
                for(int j = i + 1; j < n; j++) {
                    if(computer[j] == 1) {
                        union(i, j);
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            set.add(find(unf[i]));
        }
        
        return set.size();
    }
    
    public int find(int v) {
        if(v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }
    
    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) unf[fa] = fb;
    }
    
    
}