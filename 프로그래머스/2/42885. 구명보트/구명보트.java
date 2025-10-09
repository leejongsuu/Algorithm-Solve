import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int result = 0;
        
        Arrays.sort(people);
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        for(int p : people) {
            deque.add(p);
        }
        
        while(!deque.isEmpty()) {
            int first = deque.pollLast();
            if(!deque.isEmpty()) {
                int second = deque.peekFirst();
                if(first + second <= limit) {
                    deque.pollFirst();
                }
            }
            result++;
        }
        
        return result;
    }
}