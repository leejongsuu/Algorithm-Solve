import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int basicTime = fees[0];
        int basicCharge = fees[1];
        int unitTime = fees[2];
        int unitCharge = fees[3];
        
        Map<String, Integer> recordMap = new TreeMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        
        for(String record : records) {
            String[] strArr = record.split(" ");
            
            int time = getTimeStringtoInt(strArr[0]);
            String carNum = strArr[1];
            String dir = strArr[2];
            
            if(dir.equals("IN")) {
                timeMap.put(carNum, time);
            } else {
                int startTime = timeMap.get(carNum);
                int totalTime = time - startTime;
                recordMap.put(carNum, recordMap.getOrDefault(carNum, 0) + totalTime);
                timeMap.remove(carNum);
            }
        }
        
        for(String carNum : timeMap.keySet()) {
            int startTime = timeMap.get(carNum);
            int totalTime = (23 * 60 + 59) - startTime;
            recordMap.put(carNum, recordMap.getOrDefault(carNum, 0) + totalTime);
        }
        
        int size = recordMap.size();
        int[] result = new int[size];
        
        int i = 0;
        for(String carNum : recordMap.keySet()) {
            int time = recordMap.get(carNum);
            
            if(time <= basicTime) {
                result[i++] = basicCharge;
            } else {
                int totalTime = (time - basicTime) / unitTime;
                if((time - basicTime) % unitTime != 0) totalTime++;
                result[i++] = basicCharge + totalTime * unitCharge;
            }
        }
        
        return result;
    }
    
    private int getTimeStringtoInt(String str) {
        String[] times = str.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}