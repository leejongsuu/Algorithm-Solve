import java.util.*;

class Solution {
    
    class Food {
        int index;
        int time;
        
        Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
    
    public int solution(int[] food_times, long k) {
        
        long totalTime = 0;
        for(int t : food_times) {
            totalTime += t;
        }
        
        if(totalTime <= k) {
            return -1;
        }
        
        Comparator<Food> compTime = new Comparator<>() {
            public int compare(Food a, Food b) {
                return a.time - b.time;
            }
        };
        
        Comparator<Food> compIdx = new Comparator<>() {
            public int compare(Food a, Food b) {
                return a.index - b.index;
            }
        };
        
        PriorityQueue<Food> queue = new PriorityQueue<>(compTime);
        for(int i = 0; i < food_times.length; i++) {
            queue.offer(new Food(i + 1, food_times[i]));
        }
        
        int prevFoodTime = 0;
        
        while(!queue.isEmpty()) {
            int foodTime = queue.peek().time;
            long oneCycle = (long) (foodTime - prevFoodTime) * queue.size();
    
            if(k < oneCycle) {
                break;
            }

            k -= oneCycle;
            prevFoodTime = foodTime;
            
            queue.poll();
        }
        
        List<Food> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        Collections.sort(result, compIdx);
        
        return result.get((int) (k % result.size())).index;
    }
}