import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = solution(str1);
        Map<String, Integer> map2 = solution(str2);
        
        final int MULTI_VALUE = 65536;
        int intersection = 0;
        int sum = 0;
        
        for(String key : map1.keySet()) {
            int num1 = map1.get(key);
            if(map2.containsKey(key)) {
                int num2 = map2.get(key);
                intersection += Math.min(num1, num2);
                sum += Math.max(num1, num2);
                map2.remove(key);
            } else {
                sum += num1;
            }
        }
        
        for(String key : map2.keySet()) {
            sum += map2.get(key);
        }
        if(sum == 0) return MULTI_VALUE;
        else return (int) (((double) intersection / sum) * MULTI_VALUE);
    }
    
    public Map<String, Integer> solution(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        str = str.toLowerCase();
        
        for(int i = 0; i < str.length() - 1; i++) {
            if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1)))             {
                String key = str.substring(i, i+2);
                map.put(key, map.getOrDefault(key, 0) + 1); 
            }
        }
        
        return map;
    }
}