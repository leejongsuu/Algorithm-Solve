import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        final int MULTI_VALUE = 65536;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = getTwoWordsMap(str1);
        Map<String, Integer> map2 = getTwoWordsMap(str2);
        
        int intersection = 0;
        int sum = 0;
        
        for(String word : map1.keySet()) {
            int num1 = map1.get(word);
            if(map2.containsKey(word)) {
                int num2 = map2.get(word);
                intersection += Math.min(num1, num2);
                sum += Math.max(num1, num2);
                map2.remove(word);
            } else {
                sum += num1;
            }
        }
        
        for(String word : map2.keySet()) {
            sum += map2.get(word);
        }
        
        if(sum == 0) return MULTI_VALUE;
        else return (int) (((double) intersection / sum) * MULTI_VALUE); 
    }
    
    public Map<String, Integer> getTwoWordsMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length() - 1; i++) {
            if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                String word = str.substring(i, i + 2);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map;
    }
}