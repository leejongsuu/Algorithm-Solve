import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long soldierUsed = 0;
        
        for(int i = 0; i < enemy.length; i++) {
            soldierUsed += enemy[i];
            pq.offer(enemy[i]);
            
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