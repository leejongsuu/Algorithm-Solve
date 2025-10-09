import java.util.*;

class Solution {
    
    int[] unf;
    
    public int solution(int n, int[][] wires) {
                
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++) {
            unf = new int[n + 1];
            for(int j = 1; j <= n; j++) {
                unf[j] = j;
            }
            
            for(int j = 0; j < wires.length; j++) {
                if(i == j)  continue;
                union(wires[j][0], wires[j][1]);
            }

            Map<Integer, Integer> electMap = new HashMap<>();
            
            for(int j = 1; j <= n; j++) {
                int num = find(j);
                electMap.put(num, electMap.getOrDefault(num, 0) + 1);
            }
            
            if(electMap.size() == 2) {
                List<Integer> list = new ArrayList<>();
                for(int value : electMap.values()) {
                    list.add(value);
                }
                
                result = Math.min(result, Math.abs(list.get(0) - list.get(1)));
            }
        }
        return result;
    }
    
    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
    
    public int find(int v) {
        if(v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }
}