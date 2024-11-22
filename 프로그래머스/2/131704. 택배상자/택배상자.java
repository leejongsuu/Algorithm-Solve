import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int result = 0;
        int len = order.length;
        
        Queue<Integer> container = new LinkedList<>();
        Stack<Integer> assistance = new Stack<>();
        
        for(int i = 1; i <= len; i++) {
            container.offer(i);
        }
        
        for(int i = 0; i < len; i++) {
            while(!container.isEmpty() && container.peek() < order[i]) {
                assistance.push(container.poll());
            }
            if(!container.isEmpty() && container.peek() == order[i]) {
                container.poll();
                result++;
            } else if(!assistance.isEmpty() && assistance.peek() == order[i]) {
                assistance.pop();
                result++;
            } else {
                return result;
            }
        }
        
        return result;
    }
}