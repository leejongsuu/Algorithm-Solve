class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        boolean[] weekends = {false, false, false, false, false, true, true};
        int result = schedules.length;
        
        for(int i = 0; i < schedules.length; i++) {
            int schedule = parseTime(schedules[i], true);
            for(int j = 0; j < timelogs[i].length; j++) {
                int currentDay = (startday - 1 + j) % 7;
                if(weekends[currentDay]) continue;
                int time = parseTime(timelogs[i][j], false);
                if(time > schedule) {
                    result--;
                    break;
                }
            }
        }
        
        return result;
    }
    
    public int parseTime(int time, boolean addTen) {
        String s = String.format("%04d", time);
        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(2));
        
        if(addTen) minute += 10;
        
        hour += minute / 60;
        minute %= 60;
        
        return hour * 100 + minute;
    }
}