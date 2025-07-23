import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            n -= enemy[i];

            while(n < 0 && k > 0 && !pq.isEmpty()) {
                k--;
                n += pq.poll();
            }
            
            if(n < 0) {
                return i;
            }
        }
        
        return enemy.length;
    }
}