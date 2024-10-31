import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();
        for(String[] strArr : clothes) {
            map.put(strArr[1], map.getOrDefault(strArr[1], 0) + 1);
        }
        
        int result = 1;
        for(int value : map.values()) {
            result *= (value + 1);
        }
        
        return result - 1;
    }
}