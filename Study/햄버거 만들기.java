import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int[] pattern = new int[]{1, 2, 3, 1};
        
        for (int i : ingredient) {
            stack.push(i);
            int size = stack.size();
            
            while (size >= 4) {
                boolean isPattern = true;
                for (int j = 0; j < 4; j++) {
                    if (stack.get(size - 4 + j) != pattern[j]) {
                        isPattern = false;
                        break;
                    }
                }
                
                if (isPattern) {
                    for (int k = 0; k < 4; k++) {
                        stack.pop();
                    }
                    size -= 4;
                    result++;
                } else break;
            }
        }
        
        return result;
    }
}
