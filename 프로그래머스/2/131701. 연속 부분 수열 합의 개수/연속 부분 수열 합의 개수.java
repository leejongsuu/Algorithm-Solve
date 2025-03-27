import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        for(int i = 1; i <= len; i++) {
            for(int lt = 0; lt < len; lt++) {
                int sum = 0;
                for(int rt = lt; rt < lt + i; rt++) {
                    sum += elements[rt % len];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}