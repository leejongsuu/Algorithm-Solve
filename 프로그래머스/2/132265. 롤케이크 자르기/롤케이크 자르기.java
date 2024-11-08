import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int len = topping.length;
        int result = 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for(int t : topping) {
            map1.put(t, map1.getOrDefault(t, 0) + 1);
        }
        
        for(int i = 0; i < len - 1; i++) {
            int t = topping[i];
            map1.put(t, map1.getOrDefault(t, 0) -1);
            if(map1.get(t) <= 0) {
                map1.remove(t);
            }
            map2.put(t, map2.getOrDefault(t, 0) +1);
            
            if(map1.size() == map2.size()) {
                result++;
            }
        }
        return result;
    }
}