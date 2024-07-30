import java.util.*;

class Solution {
    
    class Process {
        int pr, index;
        
        public Process(int pr, int index) {
            this.pr = pr;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> Q = new LinkedList<>();
        for(int i=0; i < priorities.length; i++) {
            Q.offer(new Process(priorities[i], i));
        }
        
        Arrays.sort(priorities);
        // priorities 배열을 내림차순으로 뒤집습니다.
        for (int i = 0; i < priorities.length / 2; i++) {
            int temp = priorities[i];
            priorities[i] = priorities[priorities.length - 1 - i];
            priorities[priorities.length - i - 1] = temp;
        }
        int ix = 0;
        
        while (!Q.isEmpty()) {
            Process now = Q.poll();
            if(now.pr == priorities[ix]) {
                ix++;
                if(location == now.index) {
                    answer = ix;
                    break;
                }
            } else {
                Q.offer(now);
            }
        }
        
        return answer;
    }
}
