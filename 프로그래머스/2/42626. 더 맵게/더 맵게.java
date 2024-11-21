import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        int count = 0;
        while(!pq.isEmpty()) {
            int first = pq.poll();
            
            if(first >= K) return count;
            else if(pq.isEmpty()) return -1;
            else {
                int second = pq.poll();
                pq.offer(first + (second * 2));
            }
            count++;
        }
        
        return count;
    }
}