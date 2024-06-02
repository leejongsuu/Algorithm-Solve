class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int pos = 0;
        int[] stack = new int[ingredient.length];
        for(int i : ingredient) {
            stack[pos++] = i;
            if(pos > 3) {
                if(stack[pos - 1] == 1 && stack[pos - 2] == 3 && stack[pos - 3] == 2 && stack[pos - 4] == 1) {
                    answer++;
                    pos -= 4;
                }
            }
        }
        
        return answer;
    }
}