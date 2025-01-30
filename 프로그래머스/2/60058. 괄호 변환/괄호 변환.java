import java.util.*;

class Solution {
    
    public String solution(String p) {
        
        if(getIsUprightString(p)) {
            return p;
        }
        
        return separateString(p);
    }
    
    private String separateString(String str) {
        
        if(str.equals("")) {
            return "";
        }
        
        int left = 0;
        int right = 0;
        int len = str.length();
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '(') left++;
            else right++;
            
            if(left == right) {
                String u = str.substring(0, i + 1);
                String v = str.substring(i + 1, len);
                
                if(getIsUprightString(u)) {
                    return u + separateString(v);
                } else {
                    u = u.substring(1, u.length() -1);
                    char[] ch = u.toCharArray();
                    for(int j = 0; j < ch.length; j++) {
                        if(ch[j] == '(') ch[j] = ')';
                        else if(ch[j] == ')') ch[j] = '(';
                    }
                    u = String.valueOf(ch);
                    return "(" + separateString(v) + ")" + u;
                }
            }
        }
        
        return "";
    }
    
    private boolean getIsUprightString(String str) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}