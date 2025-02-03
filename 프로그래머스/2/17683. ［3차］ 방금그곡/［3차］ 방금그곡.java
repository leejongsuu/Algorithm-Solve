import java.util.*;

class Solution {
    
    class Music {
        String title;
        int playingTime;
        
        public Music(String title, int playingTime) {
            this.title = title;
            this.playingTime = playingTime;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        m = convertMelody(m);
        List<Music> musicList = new ArrayList<>();
    
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
            
            if(entireMelody.contains(m)) {
                musicList.add(new Music(title, time));
            }
        }
        
        return musicList.stream()
                .max(Comparator.comparingInt(music -> music.playingTime))
                .map(music -> music.title)
                .orElse("(None)");
        
        
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
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        
        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);
        
        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    } 
}