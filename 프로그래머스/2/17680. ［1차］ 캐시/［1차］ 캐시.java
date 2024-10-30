import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        final int HIT = 1;
        final int MISS = 5;
        
        int totalTime = 0;
        Queue<String> cache = new LinkedList<>();
        
        if(cacheSize == 0) {
            return cities.length * MISS;
        }
        
        for(String city : cities) {
            city = city.toLowerCase();
            
            boolean hit = false;
            
            for(String c : cache) {
                if(c.equals(city)) {
                    hit = true;
                    cache.remove(c);
                    break;
                }
            }
            
            if(!hit && cache.size() >= cacheSize) {
                cache.poll();
            } 
            
            cache.offer(city);
            
            totalTime += hit ? HIT : MISS;
        }
        
        return totalTime;
    }
}