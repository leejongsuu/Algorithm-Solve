import java.util.*;

class Solution {
    
    class Log {
        int start;
        int end;
        
        Log(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        
        int result = 0;
        
        List<Log> logs = new ArrayList<>();
        
        for(String line : lines) {
            String[] parts = line.split(" ");
            String time = parts[1];
            String ms = parts[2].replace("s", "");
            
            int[] times = getTime(time, ms);
            if(times[0] < 0) times[0] = 0;
            
            logs.add(new Log(times[0], times[1]));
        }
        
        int size = logs.size();
        for(int i = 0; i < size; i++) {
            int count = 1;
            int end = logs.get(i).end + 1000;
            for(int j = i + 1; j < size; j++) {
                Log log = logs.get(j);
                if(log.start < end) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        
        return result;
    }
    
    public int[] getTime(String time, String ms) {
        String[] parts = time.split(":");
        
        int endTime =
            (int) (1000 * (
            3600 * Integer.parseInt(parts[0])
            + 60 * Integer.parseInt(parts[1])
            + Double.parseDouble(parts[2])));
        
        int startTime = (int) (endTime - (Double.parseDouble(ms) * 1000) + 1);
        
        return new int[]{startTime, endTime};
    }
}