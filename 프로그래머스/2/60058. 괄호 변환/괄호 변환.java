import java.util.Stack;

class Solution {
    
    public String solution(String p) {
        return makeParentheses(p);
    }
    
    public String makeParentheses(String str) {
        int lParentheses = 0;
        int rParentheses = 0;
        int length = str.length();
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') lParentheses++;
            else if(str.charAt(i) == ')') rParentheses++;
            
            if(lParentheses == rParentheses) {
                String u = str.substring(0, i + 1);
                String v = str.substring(i + 1, length);
                
                if(isAlrightParentheses(u)) {
                    return u + makeParentheses(v);
                }
                
                StringBuffer sb = new StringBuffer();
                sb.append('(').append(makeParentheses(v)).append(')');
                sb.append(reverseParentheses(u.substring(1, u.length() - 1)));
                
                return sb.toString();
            }
        }
        return "";
    }
    
    public boolean isAlrightParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    public String reverseParentheses(String str) {
        char[] ch = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            if(ch[i] == '(') ch[i] = ')';
            else ch[i] = '(';
        }
        return String.valueOf(ch);
    }
}