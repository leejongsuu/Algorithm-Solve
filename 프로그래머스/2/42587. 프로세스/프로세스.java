import java.util.*;

class Solution {
    
    class Process {
        int location;
        int priority;
        
        Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        int result = 1;
        int len = priorities.length;
        
        Queue<Process> queue = new LinkedList<>();
        
        for(int i = 0; i < len; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        
        int[] sortedPriorities = Arrays.copyOfRange(priorities, 0, len);
        
        Arrays.sort(sortedPriorities);
        
        int index = len - 1;
        while(!queue.isEmpty() && index >= 0) {
            Process current = queue.poll();
            
            if(current.priority == sortedPriorities[index]) {
                if(current.location == location) {
                    return result;
                }
                result++;
                index--;
                
                continue;
            }
            
            queue.offer(current);
        }
        
        return -1;
    }
}