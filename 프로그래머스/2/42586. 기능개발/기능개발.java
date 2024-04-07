import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        int[] days = new int[speeds.length];
        for(int i=0; i<speeds.length; i++) {
            int sub = 100 - progresses[i];
            days[i] = sub / speeds[i];
            if(sub % speeds[i] != 0) {
                days[i]++;
            }
        }
        
        int cnt = 1, max = days[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<days.length; i++) {
            if(days[i] > max) {
                max = days[i];
                list.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        
        answer = new int[list.size()];
        for(int i=0; i < list.size(); i++) {
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}