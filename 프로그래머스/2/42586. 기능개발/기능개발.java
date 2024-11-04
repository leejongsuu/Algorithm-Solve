import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0) {
                day++;
            }
            
            if(!queue.isEmpty() && queue.peek() < day) {
                list.add(queue.size());
                queue.clear();
            }
            
            queue.offer(day);
        }
        list.add(queue.size());
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}