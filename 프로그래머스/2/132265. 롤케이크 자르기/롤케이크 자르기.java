import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> person1Map = new HashMap<>();
        Map<Integer, Integer> person2Map = new HashMap<>();
        
        person1Map.put(topping[0], 1);

        for(int i = 1; i < topping.length; i++) {
            person2Map.put(topping[i], person2Map.getOrDefault(topping[i], 0) + 1);
        }
        
        int result = 0;
        if(person1Map.size() == person2Map.size()) result++;
        
        for(int i = 1; i < topping.length; i++) {
            person1Map.put(topping[i], person1Map.getOrDefault(topping[i], 0) + 1);
            int value = person2Map.get(topping[i]);
            if(value > 1) {
                person2Map.put(topping[i], value - 1);
            } else {
                person2Map.remove(topping[i]);
            }
            if(person1Map.size() == person2Map.size()) result++;
        }
        
        return result;
    }
}