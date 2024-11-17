import java.util.*;

class Solution {
    
    class Point {
        int index;
        int number;
        
        public Point(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    
    public int[] solution(int[] numbers) {
        
        int len = numbers.length;
        int[] result = new int[len];
        
        Stack<Point> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && stack.peek().number < numbers[i]) {
                Point point = stack.pop();
                result[point.index] = numbers[i];
            }
            
            stack.push(new Point(i, numbers[i]));
        }
        
        while(!stack.isEmpty()) {
            result[stack.pop().index] = -1;
        }
        
        return result;
    }
}