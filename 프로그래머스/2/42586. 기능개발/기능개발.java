import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<speeds.length; i++) {
            double remain = 100 - progresses[i];
            double fNeedDay = remain / speeds[i];
            
            int date = (int) Math.ceil(fNeedDay);
            
            if(!Q.isEmpty() && Q.peek() < date) {
                list.add(Q.size());
                Q.clear();
            }
            
            Q.offer(date);
        }
        list.add(Q.size());
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}