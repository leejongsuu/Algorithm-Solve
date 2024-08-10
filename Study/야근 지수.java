import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            PQ.offer(work);
        }
        
        while(n > 0 && !PQ.isEmpty()) {
            int current = PQ.poll();
            current--;
            if(current > 0) {
                PQ.offer(current);
            }
            n--;
        }
        
        long result = 0;
        while(!PQ.isEmpty()) {
            int current = PQ.peek();
            result += Math.pow(PQ.poll(), 2);
        }
        
        return result;
    }
}
