import java.util.*;

class Solution {
    
    class Truck {
        int weight;
        int time;
        
        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
        
        public void decreaseTime() {
            this.time -= 1;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int result = 0;
        int curCount = 0;
        int curWeight = 0;
        int i = 0;
        
        ArrayDeque<Truck> truckQ = new ArrayDeque<>();
        truckQ.offer(new Truck(truck_weights[i], bridge_length));
        
        curWeight += truck_weights[i];
        curCount++;
        i++;
        result++;
        
        while(!truckQ.isEmpty()) {
         
            int size = truckQ.size();
            for(int j = 0; j < size; j++) {
                Truck truck = truckQ.pollFirst();
           
                truck.decreaseTime();
                if(truck.time == 0) {
                    curCount--;
                    curWeight -= truck.weight;
                    continue;
                }
    
                truckQ.offerLast(truck);
            }
            
            
            if(i < truck_weights.length && curCount < bridge_length && curWeight + truck_weights[i] <= weight) {
                curCount++;
                curWeight += truck_weights[i];
                truckQ.addLast(new Truck(truck_weights[i], bridge_length));
                i++;
            }
            result++;
        }
        
        return result;
    }
}