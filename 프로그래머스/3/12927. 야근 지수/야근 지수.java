import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            pq.offer(work);
        }
        
        for(int i = 0; i < n && !pq.isEmpty(); i++) {
            
            int work = pq.poll();
            work -= 1;
            
            if(work > 0) {
                pq.offer(work);
            }
        }
        
        long result = 0;
        while(!pq.isEmpty()) {
            result += (long) Math.pow(pq.poll(), 2);
        }
        
        return result;
    }
}