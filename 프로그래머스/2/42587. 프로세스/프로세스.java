import java.util.*;

class Solution {
    class Process {
        int index;
        int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        
        Queue<Process> queue = new LinkedList<>();
        int len = priorities.length;
        for(int i = 0; i < len; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        
        for(int i = 1; !queue.isEmpty();) {
            Process current = queue.poll();
            if(current.priority == priorities[len - i]) {
                if(current.index == location) {
                    return i;
                }
                i++;
                continue;
            }
            queue.offer(current);
        }
        
        return -1;
    }
}