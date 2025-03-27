import java.util.*;

class Solution {
    
    Map<Character, Character> map = new HashMap<>();
    
    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }
        
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        
        int result = 0;
        if(isAlright(queue)) result++;
        
        for(int i = 1; i < s.length(); i++) {
            queue.offer(queue.poll());
            if(isAlright(queue)) result++;
        }
        
        return result;
    }
    
    public boolean isAlright(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : queue) {
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                else {
                    char top = stack.pop();
                    if(map.get(top) != c) {
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}