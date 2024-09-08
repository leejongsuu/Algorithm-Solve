import java.util.Stack;

class Solution {
     public int solution(String dartResult) {
        Stack<Integer> scoreStack = new Stack<>();
         
         for(int i = 0; i < dartResult.length(); i++) {
             char c = dartResult.charAt(i);
             if(Character.isDigit(c)) {
                 if(Character.isDigit(dartResult.charAt(i+1))) {
                     scoreStack.push(10);
                     i++;
                 } else {
                     scoreStack.push(c -'0');
                 }
                 continue;
             }
             
             switch(c) {
                 case 'D' -> scoreStack.push((int) Math.pow(scoreStack.pop(), 2));
                 case 'T' -> scoreStack.push((int) Math.pow(scoreStack.pop(), 3));
                 case '#' -> scoreStack.push(-1 * scoreStack.pop());
                 case '*' -> {
                     int first = scoreStack.pop();
                     if(!scoreStack.isEmpty()) {
                         int second = scoreStack.pop();
                         scoreStack.push(2 * second);
                     }
                     scoreStack.push(2 * first);
                 }
             }
         }
         int result = 0;
         for(int score : scoreStack) {
             result += score;
         }

         return result;
    }
}