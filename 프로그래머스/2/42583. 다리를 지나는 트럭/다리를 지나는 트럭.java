import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int time = 0;
        int idx = 0;
        long sumOnBridge = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        while(idx < truck_weights.length || sumOnBridge > 0) {
            time++;
            
            sumOnBridge -= bridge.poll();
            
            if(idx < truck_weights.length && truck_weights[idx] + sumOnBridge <= weight) {
                bridge.offer(truck_weights[idx]);
                sumOnBridge += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        
        return time;
    }
}