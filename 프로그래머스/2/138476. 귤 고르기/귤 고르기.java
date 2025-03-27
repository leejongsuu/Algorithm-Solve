import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for(int t : tangerine) {
            tangerineMap.put(t, tangerineMap.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(tangerineMap.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int result = 0, sum = 0;
        for(int i : list) {
            sum += i;
            result++;
            if(sum >= k) {
                return result;
            }
        }
        return -1;
    }
}