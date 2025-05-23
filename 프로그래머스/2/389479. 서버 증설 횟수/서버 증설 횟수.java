import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int result = 0;
        Queue<Integer> times = new LinkedList<>();
        
        for(int player : players) {
            int size = times.size();
            for(int i = 0; i < size; i++) {
                int time = times.poll();
                if(time - 1 > 0) {
                    times.offer(time - 1);
                }
            }
            
            size = times.size();
            
            if(player >= (size + 1) * m) {
                int cnt = player / m - size;
                result += cnt;
                for(int i = 0; i < cnt; i++) {
                    times.offer(k);
                }
            }
        }
        
        return result;
    }
}