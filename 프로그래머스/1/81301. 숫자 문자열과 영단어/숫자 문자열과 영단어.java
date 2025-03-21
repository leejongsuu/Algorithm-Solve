import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringBuffer sb = new StringBuffer();
        
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        Map<String, Integer> digitMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            digitMap.put(words[i], i);
        }
        
        for(int lt = 0, rt = 1; rt <= s.length(); rt++) {
            String key = s.substring(lt, rt);
            if(Character.isDigit(key.charAt(0))) {
                sb.append(key);
                lt++;
            } else if(digitMap.containsKey(key)) {
                sb.append(digitMap.get(key));
                lt = rt;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}