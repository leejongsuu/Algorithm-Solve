import java.util.*;

class Solution {
    
    class Num {
        int num;
        int index;
        
        public Num(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
    
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] result = new int[len];
        
        Stack<Num> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && stack.peek().num < numbers[i]) {
                Num num = stack.pop();
                result[num.index] = numbers[i];
            }
            stack.push(new Num(numbers[i], i));
        }
        while(!stack.isEmpty()) {
            result[stack.pop().index] = -1;
        }
        
        return result;
    }
}