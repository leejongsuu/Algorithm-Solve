import java.util.Stack;

class Solution {
    public String solution(String p) {
        if(isUpright(p)) {
            return p;
        }
        return separate(p);
    }
    
    public String separate(String str) {
        if(str.isEmpty()) {
            return "";
        }
        int len = str.length();
        
        int left = 0;
        int right = 0;
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '(') left++;
            else right++;
            
            if(left == right) {
                String u = str.substring(0, i + 1);
                String v = str.substring(i + 1);
                if(isUpright(u)) {
                    return u + separate(v);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(").append(separate(v)).append(")");
                    for(int j = 1; j < u.length() - 1; j++) {
                        sb.append(u.charAt(j) == '(' ? ')' : '(');
                    }
                
                    return sb.toString();
                }
            }
        }
        
        return "";
    }
    
    public boolean isUpright(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}