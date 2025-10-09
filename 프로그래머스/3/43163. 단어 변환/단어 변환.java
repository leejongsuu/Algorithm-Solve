class Solution {
    
    int n, result = Integer.MAX_VALUE;
    
    String target;
    String[] words;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        
        n = words.length;
        visited = new boolean[n];
        
        dfs(0, begin);
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    
    public void dfs(int L, String current) {
        if(current.equals(target)) {
            result = Math.min(result, L);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(diffCount(current, words[i]) == 1) {
                    dfs(L + 1, words[i]);
                }
                visited[i] = false;
            }
        }
    }
    
    public int diffCount(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}