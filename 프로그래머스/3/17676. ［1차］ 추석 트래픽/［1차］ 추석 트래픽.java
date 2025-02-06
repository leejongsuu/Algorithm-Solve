import java.util.*;

class Solution {
    
    class Log {
        int startTime;
        int endTime;
        
        public Log(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public int solution(String[] lines) {
        
        int answer = 0;
        
        List<Log> logList = new ArrayList<>();
        
        for(String line : lines) {
            String[] parts = line.split(" ");
            int[] timeParts = getTime(parts[1], parts[2]);
            int startTime = timeParts[0];
            int endTime = timeParts[1];
            logList.add(new Log(startTime, endTime));
        }
        
        for(Log log : logList) {
            int endTime = log.endTime;
            answer = Math.max(answer, getLogCount(endTime, logList));
        }
        
        return answer;
    }
    
    public int getLogCount(int startTime, List<Log> logList) {
        int count = 0;
        int endTime = startTime + 1000;
        
        for(Log log : logList) {
            if(log.startTime < endTime && log.endTime >= startTime) {
                count++;
            }
        }
        
        return count;
    }
    
    public int[] getTime(String time, String sDuration) {
        final int thousand = 1000;
        int duration = (int) (thousand * Double.parseDouble(sDuration.replace("s", "")));
        String[] timeParts = time.split(":");
        
        int endTime = thousand * 3600 * Integer.parseInt(timeParts[0]);
        endTime += thousand * 60 * Integer.parseInt(timeParts[1]);
        endTime += (int) (thousand * Double.parseDouble(timeParts[2]));
        int startTime = endTime - duration + 1;
        
        return new int[]{startTime, endTime};
    }
}