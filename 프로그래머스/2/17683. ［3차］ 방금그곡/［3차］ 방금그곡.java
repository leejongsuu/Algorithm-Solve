import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int max = Integer.MIN_VALUE;
        
        m = convertMelody(m);

        for(String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            String startTime = infos[0];
            String endTime = infos[1];
            String title = infos[2];
            String melody = convertMelody(infos[3]);
            
            int melodyLength = melody.length();
            int time = getMinutes(startTime, endTime);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < time; i++) {
                sb.append(melody.charAt(i % melodyLength));
            }
            
            String entireMelody = sb.toString();
            
            if(entireMelody.contains(m) && time > max) {
                answer = title;
                max = time;
            }
        }
        
        return answer;
    }
    
    public String convertMelody(String melody) {
        return melody.replace("C#", "U")
                     .replace("D#", "V")
                     .replace("F#", "L")
                     .replace("G#", "M")
                     .replace("A#", "N")
                     .replace("B#", "O");
    }
    
    public int getMinutes(String startTime, String endTime) {
        int start = 60 * Integer.parseInt(startTime.substring(0,2)) + Integer.parseInt(startTime.substring(3));
        int end = 60 * Integer.parseInt(endTime.substring(0,2)) + Integer.parseInt(endTime.substring(3));
        return end - start;
    } 
}