import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> clothesMap = new HashMap<>();
        for(String[] kind : clothes) {
            clothesMap.put(kind[1], clothesMap.getOrDefault(kind[1], 0) + 1);
        }
        
        int sum = 1;
        for(int count : clothesMap.values()) {
            sum *= (count + 1);
        }
        
        return sum - 1;
    }
}