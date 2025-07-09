import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int result = 0;
        
        int n = elements.length;
        int[] dp = new int[n];
        
        Set<Integer> numberSet = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[j] += elements[(i + j) % n];
                if(numberSet.add(dp[j])) {
                    result++;
                }
            }
        }
        
        return result;
    }
}