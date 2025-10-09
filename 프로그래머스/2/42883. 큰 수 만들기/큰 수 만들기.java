import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int len = number.length();
        
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));
        
        for(int i = 1; i < len; i++) {
            while(k > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
} 