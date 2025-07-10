import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        final int multifly = 65536;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> map1 = getWordCountMap(str1);
        Map<String, Integer> map2 = getWordCountMap(str2);
        
        double sum = 0;
        double intersection = 0;
        
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                int value1 = map1.get(key), value2 = map2.get(key);
                sum += Math.max(value1, value2);
                intersection += Math.min(value1, value2);
                map2.remove(key);
            } else {
                sum += map1.get(key);
            }
        }
        
        for(String key : map2.keySet()) {
            sum += map2.get(key);
        }
        
        double J = sum == 0 ? 1 : intersection / sum;
        return (int) (J * multifly);
    }
    
    private Map<String, Integer> getWordCountMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length() - 1; i++) {
            if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                String key = str.substring(i, i + 2);
                map.put(key, map.getOrDefault(key, 0) + 1);
            } 
        }
        
        return map;
    }
}