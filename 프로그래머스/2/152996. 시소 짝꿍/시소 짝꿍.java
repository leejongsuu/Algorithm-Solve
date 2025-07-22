import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Long> map = new HashMap<>();
        for(int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }
        
        for(long value : map.values()) {
            answer += value * (value - 1) / 2;
        }
        
        for(Map.Entry<Integer, Long> e : map.entrySet()) {
            int w = e.getKey();
            Long cntW = e.getValue();
            
            int t1 = 3 * w;
            if(t1 % 2 == 0) {
                int w2 = t1 / 2;
                Long cntW2 = map.get(w2);
                if(cntW2 != null) {
                    answer += cntW * cntW2;
                }
            }
            
            int t2 = 4 * w;
            int w3 = t2 / 2;
            Long cntW3 = map.get(w3);
            if(cntW3 != null) {
                answer += cntW * cntW3;
            }
            
            int t3 = 4 * w;
            if(t3 % 3 == 0) {
                int w4 = t3 / 3;
                Long cntW4 = map.get(w4);
                if(cntW4 != null) {
                    answer += cntW * cntW4;
                }
            }
        }
        
        return answer;
    }
}