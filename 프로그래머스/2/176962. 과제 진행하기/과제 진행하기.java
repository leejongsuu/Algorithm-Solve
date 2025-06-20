import java.util.*;

class Solution {
    
    class Plan {
        String name;
        int start;
        int playTime;
        
        public Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        List<Plan> list = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();
        
        for(String[] plan : plans) {
            String name = plan[0];
            int start = toMinutes(plan[1]);
            int playTime = Integer.parseInt(plan[2]);
            list.add(new Plan(name, start, playTime));
        }
        
        list.sort((a, b) -> (a.start - b.start));
        
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < plans.length - 1; i++) {
            Plan current = list.get(i);
            int nextStart = list.get(i + 1).start;
            
            if(current.start + current.playTime <= nextStart) {
                answer.add(current.name);
                
                int duration = current.start + current.playTime;
                int gap = nextStart - duration;
                while(gap > 0 && !stack.isEmpty()) {
                    Plan prev = stack.pop();
                    if(prev.playTime <= gap) {
                        gap -= prev.playTime;
                        answer.add(prev.name);
                    } else {
                        prev.playTime -= gap;
                        gap = 0;
                        stack.push(prev);
                    }
                }
                continue;
            }
            
            current.playTime -= nextStart - current.start;
            stack.push(current);
        }
        
        answer.add(list.get(list.size() - 1).name);
        while(!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    int toMinutes(String time) {
        String[] parts = time.split(":");
        return 60 * Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
    }
}