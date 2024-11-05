import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        final int INF = 65536;
        
        int sum = 0;
        int interSection = 0;
        
        Map<String, Integer> map1 = solution(str1);
        Map<String, Integer> map2 = solution(str2);
        
        for(String key : map1.keySet()) {
            int value = map1.get(key);
            int i = 0;
            int s = value;
            if(map2.containsKey(key)) {
                int value2 = map2.get(key);
                i = Math.min(value, value2);
                s = Math.max(value, value2);
                map2.remove(key);
            }
            interSection += i;
            sum += s;
        }
        
        for(String key : map2.keySet()) {
            sum += map2.get(key);
        }
        
        if(sum == 0) {
            interSection = 1;
            sum = 1;
        }
        double similarity = (double) interSection / sum;
        return (int) (similarity * INF);
    }
    
    private Map<String, Integer> solution(String str) {
        
        str = str.toLowerCase();
        int len = str.length();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len - 1; i++) {
            String temp = str.substring(i, i+2);
            if(isAlphabet(temp)) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        
        return map;
    }
    
    private boolean isAlphabet(String str) {
        return Character.isAlphabetic(str.charAt(0)) && Character.isAlphabetic(str.charAt(1));
    }
}