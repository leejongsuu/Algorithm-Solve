import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        
        int result = 0;
        
        int[] pattern = new int[]{1, 3, 2, 1};
        Stack<Integer> ingredientStack = new Stack<>();
        
        for(int ing : ingredient) {
            
            ingredientStack.push(ing);
            
            int size = ingredientStack.size();
            if(size >= 4) {
                boolean flag = true;
                for(int i = 0; i < 4; i++) {
                    if(ingredientStack.get(size - i - 1) != pattern[i]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int i = 0; i < 4; i++) {
                        ingredientStack.pop();
                    }
                    result++;
                }
            }
        }
        return result;
    }
}