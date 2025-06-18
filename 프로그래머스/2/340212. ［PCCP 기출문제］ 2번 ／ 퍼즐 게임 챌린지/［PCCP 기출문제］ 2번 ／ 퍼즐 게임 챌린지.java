import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int lo = 1;
        int hi = Arrays.stream(diffs).max().getAsInt();
        int level = Integer.MAX_VALUE;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            long totalTime = getTotalTime(mid, diffs, times);
            
            if(totalTime <= limit) {
                hi = mid - 1;
                level = Math.min(level, mid);
            } else {
                lo = mid + 1;
            }
        }
        
        return level;
    }
    
    long getTotalTime(int level, int[] diffs, int[] times) {
        long totalTime = 0;
        long time_prev = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level) {
                totalTime += times[i];
            } else {
                totalTime += (diffs[i] - level) * (times[i] + time_prev) + times[i];
            }
            time_prev = times[i];
        }
        
        return totalTime;
    }
}