import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        int result = 0;
        List<String> cache = new ArrayList<>(cacheSize);
        
        for(int i = 0; i < cacheSize; i++) {
            if(cache.contains(cities[i])) {
                result -= 4;
                cache.remove(cities[i]);
            }
            
            result += 5;
            cache.add(cities[i]);
        }
        
        for(int i = cacheSize; i < cities.length; i++) {
            if(cache.contains(cities[i])) {
                result -= 4;
                cache.remove(cities[i]);
            }
            
            result += 5;
            cache.add(cities[i]);
            
            if(cache.size() > cacheSize) {
                cache.remove(0);
            }
        }
        
        return result;
    }
}