import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        int sum = 1;
        for(String key : map.keySet()) {
            sum *= (map.get(key) + 1);
        }
        
        answer = sum - 1;
        
        return answer;
    }
}