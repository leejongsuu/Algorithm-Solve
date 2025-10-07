import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int result = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(!pq.isEmpty()) {
            
            int first = pq.poll();
            
            if(first >= K) {
                return result;
            }
            
            if(pq.isEmpty()) {
                return -1;
            }
            
            int second = pq.poll();
            int newScoville = first + second * 2;
            
            pq.offer(newScoville);
            
            result++;
        }
        
        return -1;
    }
}