import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31 , 31, 30, 31, 30, 31};
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < days.length; i++) {
            map.put(i, days[i]);
        }
        
        int day = 0;
        for(int i = 1; i < a; i++) {
            day += map.get(i);
        }
        day += b - 1;
        
        return weeks[day % weeks.length];
    }
}