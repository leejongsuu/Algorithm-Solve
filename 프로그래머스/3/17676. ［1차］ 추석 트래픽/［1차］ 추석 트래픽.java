import java.util.*;

class Solution {
    
    class Time {
        int start;
        int end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        int answer = 0;
        
        List<Time> timeList = new ArrayList<>();
        
        for(String line : lines) {
            String[] infos = line.split(" ");
            int[] times = getTime(infos[1], infos[2]);
            int startTime = times[0];
            int endTime = times[1];
            timeList.add(new Time(startTime, endTime));            
        }
        
        for(Time time : timeList) {
            answer = Math.max(answer, Math.max(getCountDuringOneSecond(time.start, timeList), getCountDuringOneSecond(time.end, timeList)));
        }
        
        return answer;
    }
    
    public int[] getTime(String time, String duration) {
        
        final int oneThousand = 1000;
        
        String[] splited = time.split(":");
        int iDuration = (int) (Double.parseDouble(duration.replace("s", "")) * oneThousand);
        
        int endTime = 0;
        
        endTime += 3600 * oneThousand * Integer.parseInt(splited[0]);
        endTime += 60 * oneThousand * Integer.parseInt(splited[1]);
        endTime += (int) (oneThousand * Double.parseDouble(splited[2]));
        
        int startTime = endTime - iDuration + 1;
        
        return new int[]{startTime, endTime};
    }
    
    public int getCountDuringOneSecond(int time, List<Time> timeList) {
        int count = 0;
        
        int startTime = time;
        int endTime = startTime + 1000;
        
        for(Time logTime : timeList) {
            if(logTime.start < endTime && logTime.end >= startTime) {
                 count++;
            }
        }
        
        return count;
    }
}