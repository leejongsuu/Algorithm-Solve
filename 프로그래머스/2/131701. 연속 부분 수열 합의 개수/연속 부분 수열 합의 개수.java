import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int size = elements.length;
        
        Set<Integer> elementSet = new HashSet<>();
        int[] dp = new int[size];
        
        for(int len = 1; len <= size; len++) {
            for(int i = 0; i < size; i++) {
                dp[i] += elements[(len + i -1) % size];
                elementSet.add(dp[i]);
            }
        }
        
        return elementSet.size();
    }
}