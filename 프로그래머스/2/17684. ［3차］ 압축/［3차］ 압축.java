import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        int index = 27;
        int len = msg.length();
        String before = "";
        
        for(int i = 0; i < len;) {
            int j = i + 1;
            for(; j <= len; j++) {
                String temp = msg.substring(i, j);
                
                if(!map.containsKey(temp)) {
                    result.add(map.get(before));
                    map.put(temp, index++);
                    break;
                }
                
                before = temp;
            }
            
            i = j - 1;
        }
        result.add(map.get(before));
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}