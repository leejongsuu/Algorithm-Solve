import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int p_cnt = 0;
        int y_cnt = 0; 
        
        for(char c : s.toLowerCase().toCharArray()) {
            if(c == 'p') p_cnt++;
            if(c == 'y') y_cnt++;
        }
        
        if(p_cnt!=y_cnt) {
            answer = false;
        }

        return answer;
    }
}