import java.util.*;

class Solution {
    
    class Music implements Comparable<Music> {
        int index;
        int play;
        String title;
        
        Music(int index, int play, String title) {
            this.index = index;
            this.play = play;
            this.title = title;
        }
        
        public String getTitle() {
            return this.title;
        }
        
        @Override
        public int compareTo(Music o) {
            if(this.play == o.play) {
                return this.index - o.index;
            }
            return o.play - this.play;
        }
    }
    public String solution(String m, String[] musicinfos) {
        
        String cm = convert(m);
        
        List<Music> musicList = new ArrayList<>();
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            
            String startTime = infos[0];
            String endTime = infos[1];
            String title = infos[2];
            String melody = infos[3];
            
            int play = getPlayTime(startTime, endTime);
            String cmelody = convert(melody);
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < play; j++) {
                char c = cmelody.charAt(j % cmelody.length());
                sb.append(c);
            }
            
            if(sb.indexOf(cm) > -1) {
                musicList.add(new Music(i, play, title));
            }
        }
                
        Collections.sort(musicList);
        
        return musicList.isEmpty() ? "(None)" : musicList.get(0).getTitle();
    }
    
    public String convert(String str) {
        return str
            .replace("C#", "Q")
            .replace("D#", "W")
            .replace("F#", "R")
            .replace("G#", "T")
            .replace("A#", "U")
            .replace("E#", "I")
            .replace("B#", "O");
    }
    
    public int getPlayTime(String startTime, String endTime) {
        int start = 60 * Integer.parseInt(startTime.substring(0, 2))
            + Integer.parseInt(startTime.substring(3));
        
        int end = 60 * Integer.parseInt(endTime.substring(0, 2))
            + Integer.parseInt(endTime.substring(3));
        
        return end - start;
    }
}