import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        
        for(int i : scoville) {
            PQ.offer(i);
        }
        
        int level = 0;
        while(!PQ.isEmpty()) {
            int lo = PQ.poll();
            
            if(lo >= K) {
                answer = level;
                break;
            }
            
            if(!PQ.isEmpty()) {
                int nx_lo = PQ.poll();
                PQ.offer(lo + nx_lo * 2);
            }
            level++;
        }
        
        return answer;
    }
}