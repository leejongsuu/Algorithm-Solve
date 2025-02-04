class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        
        m = convertPitch(m);
        int max = Integer.MIN_VALUE;
        
        for(String musicinfo : musicinfos) {
            String infos[] = musicinfo.split(",");
            String startTime = infos[0];
            String endTime = infos[1];
            String title = infos[2];
            String melody = convertPitch(infos[3]);
            
            int len = melody.length();
            int time = calculateTime(startTime, endTime);
            StringBuilder sb = new StringBuilder();
            
            for(int t = 0; t < time; t++) {
                sb.append(melody.charAt(t % len));
            }
            
            String entireMelody = sb.toString();
            
            if(entireMelody.contains(m) && time > max) {
                answer = title;
                max = time;
            }
        }
        
        return answer;
    }
    
    private String convertPitch(String melody) {
        return melody.replace("C#", "Q")
                     .replace("D#", "W")
                     .replace("F#", "U")
                     .replace("G#", "R")
                     .replace("A#", "T")
                     .replace("B#", "Y");
    }
    
    private int calculateTime(String startTime, String endTime) {
        int start = 60 * Integer.parseInt(startTime.substring(0,2)) + Integer.parseInt(startTime.substring(3));
        int end = 60 * Integer.parseInt(endTime.substring(0,2)) + Integer.parseInt(endTime.substring(3));
        return end - start;
    }
}