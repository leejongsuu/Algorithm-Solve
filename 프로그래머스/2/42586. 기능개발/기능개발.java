import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        int len = progresses.length;
        int[] days = new int[len];
    
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0) {
                day++;
            }
            days[i] = day;
        }
        
        int max = 0;
        int key = 0;
        for(int day : days) {
            if(day > max) {
                map.put(++key, 1);
                max = day;
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        
        int[] result = new int[map.size()];
        int index = 0;
        for(int value : map.values()) {
            result[index++] = value;
        }
        
        return result;
    }
}