import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] ch = new char[16];
        for(int i = 0; i < 10; i++) {
            ch[i] = (char) (i + '0');
        }
        for(int i = 0; i < 6; i++) {
            ch[i + 10] = (char) (i + 'A');
        }
        
        for(int i = 0, j = 0; t > 0; i++) {
            Stack<Integer> stack = toScale(n, i);
            while(!stack.isEmpty() && t > 0) {
                int num = stack.pop();
                if(j % m == (p - 1)) {
                    sb.append(ch[num]);
                    t--;
                }
                j++;
            }
        }
        
        return sb.toString();
    }
    
    private Stack<Integer> toScale(int n, int num) {
        Stack<Integer> stack = new Stack<>();
        while(num >= n) {
            stack.push(num % n);
            num /= n;
        }
        stack.push(num % n);
        return stack;
    }
}