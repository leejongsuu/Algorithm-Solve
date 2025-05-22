import java.util.*;

class Solution {
    
    class Time implements Comparable<Time> {
        int time;
        char type;
        
        public Time(int time, char type) {
            this.time = time;
            this.type = type;
        }
        
        @Override
        public int compareTo(Time o) {
            if(this.time == o.time) return this.type - o.type; 
            return this.time - o.time;
        }
    }
    
    public int solution(String[][] book_time) {
        
        int len = book_time.length;
        
        List<Time> times = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            int start = getTime(book_time[i][0]);
            int end = getTime(book_time[i][1]) + 10;
            times.add(new Time(start, 's'));
            times.add(new Time(end, 'e'));
        }
        
        Collections.sort(times);
        
        int room = 0;
        int cnt = 0;
        
        for(Time t : times) {
            if(t.type == 's') {
                cnt++;
                if(cnt > room) room++;
            } else {
                cnt--;
            }
        }
        
        return room;
    }
    
    int getTime(String time) {
        String[] parts = time.split(":");
        return 60 * Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]) ;
    }
    
    
}