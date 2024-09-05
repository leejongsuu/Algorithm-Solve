import java.util.Stack;

class Solution {
    public int solution(String dartResult) {

        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if(Character.isDigit(ch)) {
                if(ch == '1' && dartResult.charAt(i+1) == '0') {
                    stack.push(10);
                    i++;
                } else {
                    stack.push(ch - '0');    
                }
                continue;
            }
            switch(ch) {
                case 'D' -> stack.push((int) Math.pow(stack.pop(), 2));
                case 'T' -> stack.push((int) Math.pow(stack.pop(), 3));
                case '#' -> stack.push(-1 * stack.pop());
                case '*' -> {
                    int second = stack.pop();
                    if(!stack.isEmpty()) {
                        int first = stack.pop();
                        stack.push(first * 2);
                    }
                    stack.push(second * 2);
                }
            }
        }
        
        int result = 0;
        for(int value : stack) {
            result+= value;
        }
        
        return result;
    }
}