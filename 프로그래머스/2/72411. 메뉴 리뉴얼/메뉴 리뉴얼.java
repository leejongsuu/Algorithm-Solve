import java.util.*;

class Solution {
    
    int size;
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }
        
        List<String> resultList = new ArrayList<>();
        
        for(int c : course) {
            size = c;
            map = new HashMap<>();
            
            for(String order : orders) {
                makeSetMenu(0, 0, order, new char[size]);
            }
            
            int max = 0;
            for(int value : map.values()) {
                max = Math.max(max, value);
            }
            
            for(Map.Entry<String, Integer> e : map.entrySet()) {
                String key = e.getKey();
                int value = e.getValue();
            }
            
            if(max > 1) {
                for(Map.Entry<String, Integer> e : map.entrySet()) {
                    int value = e.getValue();
                    if(value == max) {
                        resultList.add(e.getKey());
                    }
                }
            }
        }
        
        Collections.sort(resultList);
        int len = resultList.size();
        
        String[] result = new String[len];
        for(int i = 0; i < len; i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
    
    void makeSetMenu(int L, int start, String origin, char[] temp) {
        if(L == size) {
            String key = new String(temp);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        
        for(int i = start; i < origin.length(); i++) {
            temp[L] = origin.charAt(i);
            makeSetMenu(L + 1, i + 1, origin, temp);
        }
    }
}