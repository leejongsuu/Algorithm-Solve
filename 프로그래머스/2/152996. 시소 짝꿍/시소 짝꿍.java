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
            long cntW = e.getValue();
            
            // 3 / 2
            int w2 = w * 3;
            if(w2 % 2 == 0) {
                w2 /= 2;
                Long cntW2 = map.get(w2);
                if(cntW2 != null) {
                    answer += cntW * cntW2;
                }
            }
            
            // 4 / 2
            int w3 = w * 4;
            w3 /= 2;
            Long cntW3 = map.get(w3);
            if(cntW3 != null) {
                answer += cntW * cntW3;
            }
            
            // 4 / 3
            int w4 = w * 4;
            if(w4 % 3 == 0) {
                w4 /= 3;
                Long cntW4 = map.get(w4);
                if(cntW4 != null) {
                    answer += cntW * cntW4;
                }
            }
        }
        
        return answer;
    }
}