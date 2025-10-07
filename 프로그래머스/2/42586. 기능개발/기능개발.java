import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            double remain = 100 - progresses[i];
            int day = (int) Math.ceil(remain / speeds[i]);
            
            if(!queue.isEmpty() && queue.peek() < day) {
                list.add(queue.size());
                queue.clear();
            }
            
            queue.offer(day);
        }
        
        list.add(queue.size());
        queue.clear();
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}