class Solution {
    
    public int solution(int n, int[][] wires) {
        
        int result = Integer.MAX_VALUE;
        int len = wires.length;
        
        for(int i = 0; i < len; i++) {
            int[] unf = init(n);
            int cnt = 0;
            int cnt2 = 0;
            
            for(int j = 0; j < len; j++) {
                if(i == j) continue;
                union(wires[j][0], wires[j][1], unf);
            }
            
            for(int v = 1; v <= n; v++) {
                if(find(v, unf) == find(wires[i][0], unf)) cnt++;
                else if(find(v, unf) == find(wires[i][1], unf)) cnt2++;
            }
            
            result = Math.min(result, Math.abs(cnt - cnt2));
        }
        
        return result;
    }
    
    int[] init(int n) {
        int[] unf = new int[n + 1];
        for(int v = 1; v <= n; v++) {
            unf[v] = v;
        }
        return unf;
    }
    
    void union(int a, int b, int[] unf) {
        int fa = find(a, unf);
        int fb = find(b, unf);
        if(fa != fb) unf[fa] = fb;
    }
    
    int find(int v, int[] unf) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v], unf);
    }
}