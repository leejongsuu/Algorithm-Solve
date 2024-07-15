import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i : scoville) {
            PQ.offer(i);
        }
        
        int level = 0;
        while(!PQ.isEmpty()) {
            int first = PQ.poll();
            if(first >= K) return level;
            
            if(!PQ.isEmpty()) {
                int second = PQ.poll();
                PQ.offer(first + (second * 2));
                level++;
            }
        }
        
        return -1;
    }
}
