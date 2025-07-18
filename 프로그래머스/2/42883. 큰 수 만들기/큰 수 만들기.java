class Solution {
    public String solution(String number, int k) {
        
        int len = number.length();
        int top = -1;
        int keep = len - k;
        char[] stack = new char[len];
        
        for(int i = 0; i < len; i++) {
            char c = number.charAt(i);
            
            while(top >= 0 && k > 0 && stack[top] < c) {
                top--;
                k--;
            }
            
            stack[++top] = c;
        }
        
        return new String(stack, 0, keep);
    }
}