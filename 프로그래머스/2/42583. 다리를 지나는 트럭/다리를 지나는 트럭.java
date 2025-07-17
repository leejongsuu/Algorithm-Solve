import java.util.*;

class Solution {
    
    class Truck {
        int time;
        int weight;
        
        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int len = truck_weights.length;
        int current_weights = 0;
        
        Queue<Truck> queue = new LinkedList<>();
        
        int t = 0;
        for(int i  = 0; i < len; t++) {
            if(!queue.isEmpty()) {
                if(t - queue.peek().time >= bridge_length) {
                    current_weights -= queue.poll().weight;
                }
            }
            
            if(current_weights + truck_weights[i] <= weight && queue.size() + 1 <= bridge_length ) {
                current_weights += truck_weights[i];
                queue.offer(new Truck(t, truck_weights[i]));
                i++;
            }
        }
        
        while(!queue.isEmpty()) {
            if(t - queue.peek().time >= bridge_length) {
                    current_weights -= queue.poll().weight;
            }
            t++;
        }
        
        return t;
    }
}