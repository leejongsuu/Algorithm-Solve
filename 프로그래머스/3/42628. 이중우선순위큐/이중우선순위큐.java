import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            String[] parts = operation.split(" ");
            
            String command = parts[0];
            int val = Integer.parseInt(parts[1]);
            
            if(command.equals("I")) {
                pq.offer(val);
                rpq.offer(val);
                continue;
            }
            
            if(pq.isEmpty()) {
                continue;
            }
            
            if(val == 1) {
                Integer max = rpq.poll();
                pq.remove(max);
            } else {
                Integer min = pq.poll();
                rpq.remove(min);
            }
        }
        
        if(pq.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{rpq.poll(), pq.poll()};
        }
    }
}