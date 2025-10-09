import java.util.*;

class Solution {
    
    final int N = 5;
    final char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    int num = 0, result = -1;
    boolean isFound = false;
    String target;
    
    public int solution(String word) {
        this.target = word;    

        dfs(0, "");
        
        return result;
    }
    
    public void dfs(int L, String str) {
        
        if(!str.isEmpty() && str.equals(target)) {
            result = num;
            isFound = true;
            return;
        }
        
        if(L == N || isFound) {
            return;
        }
        
        
        for(int i = 0; i < N; i++) {
            num++;
            dfs(L + 1, str + alphabet[i]);
        }
    }
}