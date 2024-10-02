import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == word) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}