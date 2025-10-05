import java.util.*;

class Solution {
    public String solution(String p) {
        
        return alter(p);
    }
    
    public String alter(String w) {
        
        if(w.equals("")) {
            return "";
        }
        
        int left = 0;
        int right = 0;
        
        String u ="";
        String v = "";
        
        for(int i = 0; i < w.length(); i++) {
            if(w.charAt(i) == '(') left++;
            else right++;
            
            if(left == right) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break;
            }
        }
        
        if(checkAlright(u)) {
            return u + alter(v);
        } else {
            String s = "(" + alter(v) + ")";
            u = u.substring(1, u.length() - 1);
            char[] ch = u.toCharArray();
            for(int i = 0; i < ch.length; i++) {
                if(ch[i] == '(') ch[i] = ')';
                else ch[i] = '(';
            }
            return s + String.valueOf(ch);
        }
    }
    
    public boolean checkAlright(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}