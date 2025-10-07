import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int result = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(String[] strArr : clothes) {
            map.put(strArr[1], map.getOrDefault(strArr[1], 1) + 1);
        }
        
        for(int cnt : map.values()) {
            result *= cnt;
        }
        
        return Math.max(result - 1, 1);
    }
}