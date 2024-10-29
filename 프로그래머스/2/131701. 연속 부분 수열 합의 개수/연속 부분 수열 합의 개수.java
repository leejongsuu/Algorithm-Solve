import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> elementSet = new HashSet<>();
        
        int max_len = elements.length;
        int[] dp = new int[max_len];
        
        for(int len = 1; len <= max_len; len++) {
            for(int i = 0; i < max_len; i++) {
                dp[i] += elements[(i + len - 1) % max_len];
                elementSet.add(dp[i]);
            }
        }
        
        return elementSet.size();
    }
}