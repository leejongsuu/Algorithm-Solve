import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    
    class Box implements Comparable<Box> {
        int bno;
        int count;
        
        public Box(int bno, int count) {
            this.bno = bno;
            this.count = count;
        }
        
        public void setCount(int count) {
            this.count = count;
        }
        
        @Override
        public int compareTo(Box o) {
            return o.count - this.count;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tangerineMap = new HashMap<>();
        for(int num : tangerine) {
            tangerineMap.put(num, tangerineMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Box> queue = new PriorityQueue<>();
        for(int key : tangerineMap.keySet()) {
            queue.offer(new Box(key, tangerineMap.get(key)));
        }
        
        int result = 0;
        int number = 0;
        int before = 0;
        while(number < k && !queue.isEmpty()) {            
            Box currentBox = queue.peek();
            if(before != currentBox.bno) {
                result++;
            }
            before = currentBox.bno;
            
            int cnt = currentBox.count;
            if(cnt == 1) {
                queue.poll();
            } else {
                currentBox.setCount(cnt - 1);    
            }
            
            number++;
        }
        
        return result;
    }
}