import java.util.Stack;

class Solution {
    
    public int solution(int n) {
        
        Stack<Integer> stack = new Stack<>();
        while(n > 2) {
            stack.push(n % 3);
            n /= 3;
        }
        stack.push(n);
        
        int len = 0;
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop() * (int) Math.pow(3, len++);
        }
        
        return sum;
    }
}
    
    
