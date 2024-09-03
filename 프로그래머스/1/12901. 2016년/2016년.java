import java.util.HashMap;

class Solution {
    public String solution(int a, int b) {
        
        int[] thirty = new int[]{4,6,9,11};
        int[] thirty_one = new int[]{1,3,5,7,8,10,12};
        
        HashMap<Integer, Integer> dayMap = new HashMap<>();
        dayMap.put(2, 29);
        for(int i = 0; i < thirty.length; i++) {
            dayMap.put(thirty[i], 30);
        }
        for(int i = 0; i < thirty_one.length; i++) {
            dayMap.put(thirty_one[i], 31);
        }
        
        int day = 0;
        
        for(int month = 1; month < a; month++) {
            day += dayMap.get(month);
        }
        day += b;
        
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        return week[(day - 1) % 7];
    }
}