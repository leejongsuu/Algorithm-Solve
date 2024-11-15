import java.util.*;

class Solution {
    
    class Num {
        int index;
        int number;
        
        public Num(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    
    public int[] solution(int[] numbers) {
        
        int len = numbers.length;
        int[] result = new int[len];
        
        Stack<Num> stack = new Stack<>();
        stack.push(new Num(0, numbers[0]));
        
        for(int i = 1; i < len; i++) {
            while(!stack.isEmpty() && stack.peek().number < numbers[i]) {
                Num num = stack.pop();
                result[num.index] = numbers[i];
            }
            stack.push(new Num(i, numbers[i]));
        }
        
        while(!stack.isEmpty()) {
            Num num = stack.pop();
            result[num.index] = -1;
        }
        
        return result;
    }
}