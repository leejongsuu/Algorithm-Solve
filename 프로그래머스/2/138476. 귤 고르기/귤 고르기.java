import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        
        for(int t : tangerine) {
            tangerineMap.put(t, tangerineMap.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(tangerineMap.values());
        list.sort((o1, o2) -> o2 - o1);
        
        int result = 0;
        for(int cnt : list) {
            k-=cnt;
            result++;
            if(k <= 0) {
                break;
            }
        }
        return result;
    }
}