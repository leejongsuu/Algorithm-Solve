import java.util.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }
                
        for(int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(char c : queue) {
                if(c == '[' || c == '(' || c == '{') {
                    stack.push(c);
                } else if(stack.isEmpty() || map.get(stack.pop()) != c) {
                    flag = false;
                    break;
                }
            }
            if(flag && stack.isEmpty()) {
                result++;
            }
            queue.offer(queue.poll());
        }
        
        return result;
    }
}