import java.util.*;

class Solution {
    
    class Log {
        int start;
        int end;
        
        public Log(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        int result = 0;
        
        List<Log> logList = new ArrayList<>();
        
        for(String line : lines) {
            String[] parts = line.split(" ");
            String time = parts[1];
            String seconds = parts[2];
            Log log = calculateLogTime(time, seconds);
            logList.add(log);
        }
        
        for(Log log : logList) {
            result = Math.max(result, countPerLog(log.end, logList));
        }
        
        return result;
    }
    
    public Log calculateLogTime(String time, String seconds) {
        final int thousand = 1000;
        
        seconds = seconds.replaceAll("s", "");
        int iSeconds = (int) (Double.parseDouble(seconds) * thousand);
        
        int start = 0;
        int end = 0;
        
        String[] parts = time.split(":");
        end += Integer.parseInt(parts[0]) * 60 * 60 * thousand;
        end += Integer.parseInt(parts[1]) * 60 * thousand;
        end += (int) (Double.parseDouble(parts[2]) * thousand);
        
        start = end - iSeconds + 1;
        
        return new Log(start, end);
    }
    
    public int countPerLog(int start, List<Log> logList) {
        int count = 0;
        int end = start + 1000;
        for(Log log : logList) {
            if(log.start < end && start <= log.end) {
                count++;
            }
        }
        return count;
    }
}