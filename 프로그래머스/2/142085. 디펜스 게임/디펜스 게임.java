import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long soldierUsed = 0;
        for(int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            
            soldierUsed += e;
            pq.offer(e);
            
            if(soldierUsed > n) {
                if(k > 0) {
                    soldierUsed -= pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}