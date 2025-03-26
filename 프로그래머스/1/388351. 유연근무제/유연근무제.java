import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        boolean[] weekOfDays = {false, false, false, false, false, true, true};
        
        int result = schedules.length;
        
        for(int i = 0; i < schedules.length; i++) {
            int schedule = getScheduleTime(schedules[i]);
            int day = startday - 2;
            
            for(int j = 0; j < timelogs[i].length; j++) {
                day++;
                if(weekOfDays[day % 7]) continue;
                
                if(getTime(timelogs[i][j]) > schedule) {
                    result--;
                    break;
                }
            }
        }
        
        return result;
    }
    
    public int getTime(int num) {
        String time = String.format("%04d", num);
        int hour = Integer.parseInt(time.substring(0,2)) * 100;
        int minute = Integer.parseInt(time.substring(2));
        return hour + minute;
    }
    
    public int getScheduleTime(int num) {
        String time = String.format("%04d", num);
        int hour = Integer.parseInt(time.substring(0,2)) * 100;
        int minute = Integer.parseInt(time.substring(2)) + 10;
        if(minute >= 60) {
            hour += 100;
            minute -= 60;
        }
        return hour + minute;
    }
}