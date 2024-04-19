import java.util.*;

class Solution {
    boolean solution(String s) {
        
        int cnt = 0;
        
        
        for(char c : s.toLowerCase().toCharArray()) {
            if(c == 'p') cnt++;
            if(c == 'y') cnt--;
        }

        return cnt == 0 ? true : false;
    }
}