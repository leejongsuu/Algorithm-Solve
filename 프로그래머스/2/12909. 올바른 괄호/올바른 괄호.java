import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c=='(') count ++;
            else if(c==')') count --;
            
            if(count < 0) {
                answer = false;
                break;
            }
        }
        if(count !=0) answer = false;

        return answer;
    }
}