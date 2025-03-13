import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int max = Integer.MIN_VALUE;
        
        m = convertMelody(m);
        
        for(String musicinfo : musicinfos) {
            String[] parts = musicinfo.split(",");
            String startTime = parts[0];
            String endTime = parts[1];
            String title = parts[2];
            String music = parts[3];
            
            StringBuffer sb = new StringBuffer();
            int timeLength = calculateTimeLength(parts[0], parts[1]);
            music = convertMelody(music);
            int len = music.length();
            for(int i = 0; i < timeLength; i++) {
                sb.append(music.charAt(i % len));
            }
            
            String str = sb.toString();
            if(str.contains(m) && timeLength > max) {
                    max = timeLength;
                    answer = title;
            }
        }
        
        return answer;
    }
    
    private String convertMelody(String melody) {
        return melody
            .replace("C#", "Q")
            .replace("D#", "W")
            .replace("F#", "R")
            .replace("G#", "T")
            .replace("A#", "Y")
            .replace("B#", "U");
    }
    
    private int calculateTimeLength(String start, String end) {
        int endTime = 0;
        endTime += 60 * Integer.parseInt(end.substring(0, 2));
        endTime += Integer.parseInt(end.substring(3));
        
        int startTime = 0;
        startTime += 60 * Integer.parseInt(start.substring(0, 2));
        startTime += Integer.parseInt(start.substring(3));
        
        return endTime - startTime;
    }
}