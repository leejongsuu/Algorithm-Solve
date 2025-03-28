import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        
        int len = elements.length;
    
        int[] dp = new int[len];
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < len; j++) {
                dp[j] += elements[(i + j - 1) % len];
                set.add(dp[j]);
            }
        }
        
        return set.size();
    }
}